package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long SERVERS = 1L;
    private final int code;
    private final String phone;

    public Contact(int code, String phone) {
        this.code = code;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Contact{"
                + "code=" + code
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(54676, "89617753416");
        File tempFile = Files.createTempFile(null, null).toFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            oos.writeObject(contact);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tempFile))) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }
}
