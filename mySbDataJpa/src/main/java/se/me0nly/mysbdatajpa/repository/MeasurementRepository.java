package se.me0nly.mysbdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.me0nly.mysbdatajpa.entity.Measurement;

public abstract class MeasurementRepository implements CrudRepository<Measurement, String> {
    public static Measurement DECILITRE;
    public static Measurement GRAM;
}
