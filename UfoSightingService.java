package app.lloyds.test;
import java.util.*;

public interface UfoSightingService {
	/**
     * Returns all the sightings in the tsv file.
     */
    List<UfoSighting> getAllSightings();

    /**
     * Search for sightings happened in the specified year and month;
     *
     * @param yearSeen  The year when the sighting happened
     * @param monthSeen The month when the sightings happened
     */
    List<UfoSighting> search(int yearSeen, int monthSeen);



}
