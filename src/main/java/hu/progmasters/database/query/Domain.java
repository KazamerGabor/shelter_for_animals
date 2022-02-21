package hu.progmasters.database.query;

import hu.progmasters.enums.Sex;

import java.util.Scanner;

public class Domain {
    Scanner sc;
    public static String selectedDog;

    public void selectedBreed() {

        sc = new Scanner(System.in);
        System.out.println("Válassz egy fajtát:");
        System.out.println("1, husky\n2, németjuhász\n3, malamut\n4, szetter\n5, labrador\n" +
                "6, vizsla\n7, yorkshire\n8, foxi\n9, tacskó\n10, foxi\n11, beagle\n" +
                "12, retriever\n13, kopó\n14, palotapincsi\n15, spániel\n");

        int num = 0;
        try {
            num = sc.nextInt();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        while (num < 16 && num > 0) {
            switch (num) {
                case 1:
                    selectedDog.concat("husky");
                    break;
                case 2:
                    selectedDog.concat("németjuhász");
                    break;
                case 3:
                    selectedDog.concat("malamut");
                    break;
                case 4:
                    selectedDog.concat("szetter");
                    break;
                case 5:
                    selectedDog.concat("labrador");
                    break;
                case 6:
                    selectedDog.concat("vizsla");
                    break;
                case 7:
                    selectedDog.concat("yorkshire");
                    break;
                case 8:
                    selectedDog.concat("foxi");
                    break;
                case 9:
                    selectedDog.concat("tacskó");
                    break;
                case 10:
                    selectedDog.concat("foxi");
                    break;
                case 11:
                    selectedDog.concat("beagle");
                    break;
                case 12:
                    selectedDog.concat("retriever");
                    break;
                case 13:
                    selectedDog.concat("kopó");
                    break;
                case 14:
                    selectedDog.concat("palotapincsi");
                    break;
                case 15:
                    selectedDog.concat("spániel");
                    break;
                default:
                    System.out.println("Ilyen kutya nincs, válassz másikat");
            }
            num = sc.nextInt();
        }
        System.out.println(selectedDog);
    }


    public void selectedSex() {

        sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Milyen nemű kutyát szeretnél:");
        System.out.println("1, kan\n2, nőstény\n");

        try {
            num = sc.nextInt();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        while (num < 3 && num > 0) {
            switch (num) {
                case 1:
                    selectedDog.concat(Sex.MALE + " ");
                    break;
                case 2:
                    selectedDog.concat(Sex.FEMALE + " ");
                    break;
                default:
                    System.out.println("Nincs ilyen nemű kutya, válassz másikat!");
            }
            num = sc.nextInt();
        }
        System.out.println(selectedDog);

    }

    public void selectedAge() {

        sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Milyen korú legyen a kutya:");
        System.out.println("1, fiatal\n2, közepes\n3, öreg");
        while (num > 0 && num < 4) {
            switch (num) {
                case 1:
                    selectedDog.concat("fiatal");
                    break;
                case 2:
                    selectedDog.concat("közepes");
                    break;
                case 3:
                    selectedDog.concat("öreg");
                    break;
                default:
                    System.out.println("Nincs ilyen korú kutya, válassz másikat!");
            }
            sc.nextInt();
        }
        System.out.println(selectedDog);

    }


}