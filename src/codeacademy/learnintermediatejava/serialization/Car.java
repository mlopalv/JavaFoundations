package codeacademy.learnintermediatejava.serialization;

import java.io.*;

/***
 * Esta clase muestra ejemplos claros de serialización y deserialización
 *
 *
 */
public class Car implements Serializable{
    private String make;
    //Todos los tipos primitivos como int, double, real, son serializables
    private int year;
    //Una variable que se clasifica como static es una variable que se puede acceder sin necesidad de tener una instancia del objeto
    // es decir, es una variable que pertenece a la clase y no al objeto.
    // estas variables estàticas no son serializadas
    private static final long serialVersionUID=1L;
    //Una variable que se clasifica como transient no es tenida en cuenta durante el proceso de serialización
    private transient String model;

    // Como engine no implementa Serializable, entonces el objeto no se puede serializaar.
    // Si desarrollamos una sobreescritura del método writeObject() y readObject(), se puede serializar
    // tomando cada una de las propiedades el object y haciendo el proceso de serializaciòn (las propiedades de engine son variables primitivas)
    private Engine engine;

    public Car(String make, int year, String model){
        this.make = make;
        this.year = year;
        this.model = model;
        this.engine = new Engine(2.4, 6);

    }
    //Sobrescritura del método writeObject() de la interface Serializable
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeObject(this.make);
        stream.writeInt(this.year);
        stream.writeInt(this.engine.getCylinders());
        stream.writeDouble(this.engine.getLiters());
    }

    // Sobrescritura del método readObject() de la interface Serializable
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        this.make = (String)stream.readObject();
        this.year = (int)stream.readInt();
        int cylinders = (int)stream.readInt();
        double liters = (double)stream.readDouble();
        this.engine = new Engine(liters, cylinders);
    }

    public String toString(){
        return String.format("Car make is: %s, Car year is: %d, Car model is: %s, serialVersionUID: %d", this.make, this.year, this.model, serialVersionUID);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Object Serialization
        Car toyota = new Car("Toyota", 2021, "Corolla");
        Car honda = new Car("Honda", 2020, "Civic");
        FileOutputStream fileOutputStream = new FileOutputStream("c:/tmp/cars.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(toyota);
        objectOutputStream.writeObject(honda);

        //Object deserialization
        FileInputStream fileInputStream = new FileInputStream("c:/tmp/cars.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Car toyotaCopy = (Car) objectInputStream.readObject();
        Car hondaCopy = (Car) objectInputStream.readObject();
        boolean isSameObject = toyotaCopy==toyota;
        //Se puede ver que los valores de los objetos serializados y deserializados son los mismos
        System.out.println(toyota);
        //Nótese que la copia del objeto tiene un valor de null en la variable model (esto debido a que no se tiene en cuenta en el proceso de serialización)
        System.out.println(toyotaCopy);
        //Se puede ver que la instancia (o el valor que se asigna en memoria) no es el mismo
        System.out.println("Is same object: "+isSameObject);
    }


}
