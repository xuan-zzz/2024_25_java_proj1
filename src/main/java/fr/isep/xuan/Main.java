package fr.isep.xuan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.isep.xuan.Vol.obtenirVol;


public class Main {
    public static List<Avion> avions = new ArrayList<Avion>();
    public static Map<String, Vol> volMap = new HashMap<String, Vol>();
    public static Map<String, Aeroport> portMap = new HashMap<String, Aeroport>();
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir") );
        List<Map<String, String>> csv = lireCSV();
        csv.forEach(map -> {
            //map.forEach((key, value) -> System.out.println(key + ": " + value));
            //System.out.println("-----");
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
                System.out.println(portMap.get(map.get("Dép")).getNom());
                volMap.put(map.get("Code"), new Vol(map.get("Code"), portMap.get(map.get("Dép")),
                        portMap.get(map.get("Arriv")), jour, mois, heure, minute));
            }
        });
        for (String key : volMap.keySet()){
            obtenirVol(key);
        }
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

}
