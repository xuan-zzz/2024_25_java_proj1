package fr.isep.xuan;

import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static List<Avion> avionsLibres = new ArrayList<>();
    public static List<Pilote> pilotes = new ArrayList<>();
    public static List<Passager> passagers = new ArrayList<>();
    public static List<PersonnelCabine> personnelCabines = new ArrayList<>();
    public static Map<String, Vol> volMap = new LinkedHashMap<>();
    public static Map<String, Aeroport> portMap = new HashMap<>();
    public static Set<Integer> immatriculations = new HashSet<>();
    public static String[] prenoms;
    public static String[] noms;
    public static Set<Integer> numEmploye = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Random rdm = new Random();
        noms = readNames("noms.txt");
        prenoms = readNames("noms2.txt");

        String[] aeroportsNoms = readNames("aeroportsNoms.txt"); //génère des aéroports à partir d'un fichier txt
        String[] aeroportsCodes = readNames("aeroportsCodes.txt");
        for (int i = 0; i<aeroportsNoms.length; i++){
            portMap.put(aeroportsCodes[i], new Aeroport(aeroportsCodes[i], aeroportsNoms[i]));}
        for (int i = 0; i<20; i++) avionsLibres.add(new Avion()); // génères 20 avions aléatoirement
        for (int i = 0; i<40; i++) pilotes.add(new Pilote()); // génère 20 pilotes aléatoirement
        for (int i = 0; i<100; i++) personnelCabines.add(new PersonnelCabine()); // génère 100 presonnel de cabine
        for (int i = 0; i<2000; i++) passagers.add(new Passager()); //génère 2000 passagers

        LocalDateTime start = LocalDateTime.of(2025, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2025, 12, 31, 0, 0);
        int mins = (int) ChronoUnit.MINUTES.between(start, end);

        for (int i = 0; i<20; i++){ // crée 20 vols
            String numVol = "";
            while (numVol.isEmpty() || volMap.containsKey(numVol)) {
                char lettre1 = (char) ('A' + rdm.nextInt(26));
                char lettre2 = (char) ('A' + rdm.nextInt(26));
                String nums = String.format("%03d",rdm.nextInt(1000));
                numVol = lettre1 + "" + lettre2 + nums;
            }
            String[] listeAeroports = portMap.keySet().toArray(new String[0]);
            String depart = listeAeroports[rdm.nextInt(listeAeroports.length)];
            String arrive = listeAeroports[rdm.nextInt(listeAeroports.length)];
            while (Objects.equals(depart, arrive))
                arrive = listeAeroports[rdm.nextInt(listeAeroports.length)];
            int delta = ( rdm.nextInt(mins) / 5 ) * 5;
            LocalDateTime date = start.plusMinutes(delta);

            volMap.put(numVol, new Vol(numVol, portMap.get(depart), portMap.get(arrive), date));
        }

        for (Vol v: volMap.values()){ // assigne 2 pilotes et 5 personnel de cabine à chaque vole
            LinkedList<Employe> pdc = new LinkedList<Employe>();
            for (int i=0; i<5; i++) {
                if (!personnelCabines.isEmpty())
                    pdc.add(personnelCabines.removeFirst());
                else {
                    System.out.println("Il n'y a plus de personnel cabine disponibles !");
                    break;
                }
            }
            LinkedList<Employe> pil = new LinkedList<Employe>();
            for (int i=0; i<2; i++) {
                if (!pilotes.isEmpty())
                    pil.add(pilotes.removeFirst());
                else {
                    System.out.println("Il n'y a plus de pilotes disponibles !");
                    break;
                }
            }
            v.setEmployeMap(new HashMap<String, LinkedList<Employe>>()      {{
                put("Pilotes", pil);
                put("Personnel de Cabine", pdc);                            }});
        }

        //importFlights();

        //customPassager();
    }

    public static void customPassager(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Quel est votre nom ?");
        String nom = scan.nextLine();
        System.out.println("Quel est votre prénom ?");
        String prenom = scan.nextLine();
        System.out.println("Quel est votre numéro de passeport ?");
        String passeport = scan.nextLine();
        System.out.println("Quel est votre adresse ?");
        String adresse = scan.nextLine();
        System.out.println("Quel est votre e-mail ?");
        String contacte = scan.nextLine();
        Passager p = new Passager(nom, prenom, adresse, contacte, passeport);
        int i = 1;
        ArrayList<String> numVol = new ArrayList<>(volMap.keySet());
        System.out.println("-----");
        for (String num : numVol){
            System.out.println(i++);
            volMap.get(num).obtenirVol();
            System.out.println("-----");
        }
        System.out.println("Quel est le vol que vous souhaitez réserver ? (numéro entre 1 et "
                + volMap.size() + ")");
        int n = scan.nextInt();
        scan.nextLine();
        Vol v = volMap.get(numVol.get(n-1));
        DateTimeFormatter format = new DateTimeFormatterBuilder()
                .appendPattern("dd MMMM") // Day and Month
                .appendLiteral(", ") // Comma and space
                .appendPattern("HH:mm") // Hour and minute
                .toFormatter();
        System.out.println("Est-ce que les informations suivantes sont correctes ?");
        System.out.println("Passager: " + nom + " " + prenom + ". Numéro de passeport: " +
                passeport);
        System.out.println("Vol " + v.getNumeroVol() + " au départ de " +v.getOrigine().getNom() +
                " à destination de " + v.getDestination().getNom() + ", prévu le " +
                format.format(v.getDate()));
        if (p.reserverVol(v)){
            System.out.println("Vous avez réservé le vol.");
        } else System.out.println("Le vol est plein");
    }

    public static void importFlights() throws IOException{
        List<Map<String, String>> csv = lireCSV();
        csv.forEach(map -> {
            if (!volMap.containsKey(map.get("Code"))){
                if (!portMap.containsKey(map.get("Dép"))) {
                    portMap.put(map.get("Dép"), new Aeroport(map.get("Dép")));
                }
                if (!portMap.containsKey(map.get("Arriv"))) {
                    portMap.put(map.get("Arriv"), new Aeroport(map.get("Arriv")));
                }
                String[] split = map.get("Heure").split(":");
                int heure = Integer.parseInt(split[0]);
                int minute = Integer.parseInt(split[1]);
                split = map.get("Date").split("-");
                int jour = Integer.parseInt(split[0]);
                int mois = Integer.parseInt(split[1]);
                volMap.put(map.get("Code"), new Vol(map.get("Code"), portMap.get(map.get("Dép")),
                        portMap.get(map.get("Arriv")), jour, mois, heure, minute));
            }
        });
    }

    public static List<Map<String, String>> lireCSV() throws IOException {

        Reader in = new FileReader("./vols.csv");

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(new String[]{"Code", "Dép", "Arriv", "Date", "Heure"})
                .setSkipHeaderRecord(true)
                .setDelimiter('|')
                .setIgnoreSurroundingSpaces(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);

        List<Map<String,String>> vols = new ArrayList<>();
        for (CSVRecord record : records) {
            Map<String,String> vol = new HashMap<>();
            vol.put("Code", record.get("Code"));
            vol.put("Dép", record.get("Dép"));
            vol.put("Arriv", record.get("Arriv"));
            vol.put("Date", record.get("Date"));
            vol.put("Heure", record.get("Heure"));
            vols.add(vol);
        }

        in.close();
        //System.out.println(vols);
        return vols;
    }

    public static String[] readNames(String path){
        try {
            Path filePath = Path.of(path);
            List<String> lines = Files.readAllLines(filePath);
            return lines.toArray(new String[0]);
        } catch (IOException _) {}
        return new String[]{};
    }

}
