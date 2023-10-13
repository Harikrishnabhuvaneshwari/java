package com.java17.records;

import java.util.Objects;


public class Student {

    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    class Inner {
        public String innerString;

        public Inner(String innerString) {
            this.innerString = innerString;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "innerString='" + innerString + '\'' +
                    '}';
        }
    }
}
