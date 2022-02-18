package hu.progmasters.database.query;

import hu.progmasters.animals.Dog;
import hu.progmasters.animals.DogCoat;
import hu.progmasters.animals.DogHealth;
import hu.progmasters.enums.*;
import hu.progmasters.humans.Address;
import hu.progmasters.humans.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadTexts {

//    List<Dog> dogList = new ArrayList<>();
//    List<Worker> workerList = new ArrayList<>();
//
//    public void readDogText() {
//        Path path = Path.of("src/main/resources/dog.txt");
//        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
//            String line;
//            bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] lines = line.split(";");
//                String name = lines[0];
//                String breed = lines[1];
//                String dateOfBirth = lines[2];
//                Sex sex = Sex.valueOf(lines[3].toUpperCase());
//                int weight = Integer.valueOf(lines[4]);
//                Status status = Status.valueOf(lines[5].toUpperCase());
//                DogCoat dogCoat = new DogCoat(CoatColor.valueOf(lines[6].toUpperCase()),
//                        CoatLength.valueOf(lines[7].toUpperCase()), Shedding.valueOf(lines[8].toUpperCase()));
//                DogHealth dogHealth = new DogHealth(Boolean.valueOf(lines[9]), Boolean.valueOf(lines[10]),
//                        HealthStatus.valueOf(lines[11].toUpperCase()));
//
//                dogList.add(new Dog(name, breed, dateOfBirth, sex, weight, status, dogCoat, dogHealth));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void readWorkerText() {
//        Path path = Path.of("src/main/resources/worker.txt");
//        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
//            String line;
//            bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] lines = line.split(";");
//                String name = lines[0];
//                int phoneNumber = Integer.parseInt(lines[1]);
//                String city = lines[2];
//                int postalCode = Integer.parseInt(lines[3]);
//                String street = lines[4];
//                int number = Integer.parseInt(lines[5]);
//
//                workerList.add(new Worker(name, phoneNumber, new Address(city, postalCode, street, number)));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
