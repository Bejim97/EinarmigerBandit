import java.util.Random;

class EinarmigerBandit {

    public static void main(String[] args) {
        // erstellt eine Instanz der Random-Klasse
        Random zufall = new Random();
        int kirschPunkte = 3;
        int herzPunkte = 15;
        int pikPunkte = 20;
        double gesamtPunkte = 0.0;
        int runde = 1;

        // Während die Gesamtpunktzahl kleiner als 120 ist und die Rundenanzahl kleiner oder gleich 3 ist
        while (gesamtPunkte <= 120.0 && runde <= 3) {
            int kirschAnzahl = 0;
            int herzAnzahl = 0;
            int pikAnzahl = 0;
            int zahlAnzahl = 0;
            double rundenPunkte = 0.0;

            // Simulieren des drehens der Walze
            for (int i = 0; i < 3; i++) {
                int symbol = zufall.nextInt(4);
                if (symbol == 0) {
                    System.out.println("Kirsche " + kirschPunkte);
                    kirschAnzahl++;
                    rundenPunkte += kirschPunkte;
                } else if (symbol == 1) {
                    int zahl = (zufall.nextInt(4) + 7);
                    System.out.println("Zahl " + zahl);
                    zahlAnzahl++;
                    rundenPunkte += zahl;
                } else if (symbol == 2) {
                    System.out.println("Herz "+ herzPunkte);
                    herzAnzahl++;
                    rundenPunkte += herzPunkte;
                } else {
                    System.out.println("Pik " + pikPunkte);
                    pikAnzahl++;
                    rundenPunkte += pikPunkte;
                }
            }
            // Überprüfe ob es eine Bonusrunde gibt
            if (kirschAnzahl == 3) {
                rundenPunkte *= 1.5;
            } else if (herzAnzahl == 3) {
                rundenPunkte *= 1.5;
            } else if (pikAnzahl == 3) {
                rundenPunkte *= 1.5;
            } else if (zahlAnzahl == 3) {
                rundenPunkte *= 1.5;
            }
            // Füge Rundenpunkte zu Gesamtpunkten hinzu
            gesamtPunkte += rundenPunkte;
            System.out.println("Rundenpunkte: " + rundenPunkte);
            System.out.println("Gesamtpunkte: " + gesamtPunkte);
            runde++;
        }

        // Überprüfe ob das Spiel gewonnen oder verloren wurde
        if (gesamtPunkte >= 120) {
            System.out.println("Gewonnen mit " + gesamtPunkte + " Punkten.");
        } else {
            System.out.println("Verloren mit " + gesamtPunkte + " Punkten.");
        }
    }
}
