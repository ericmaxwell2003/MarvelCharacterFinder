package software.credible.mcfinder.remote;

import java.util.Date;

import retrofit.http.GET;
import retrofit.http.Query;
import software.credible.mcfinder.remote.dto.MarvelResultWrapper;

public interface MarvelRemoteApi {

    @GET("/characters")
    MarvelResultWrapper fetchAllCharacters(

            // Return only characters matching the specified full character name
            @Query("name") String name,

            // Return characters with names that begin with the specified string
            @Query("nameStartsWith") String nameStartsWith,

            // Return only characters which have been modified since the specified date
            @Query("modifiedSince") Date modifiedSince,

            // Return only characters which appear in the specified comics (accepts a comma-separated list of ids)
            @Query("comics") int comics,

            // Return only characters which appear the specified series (accepts a comma-separated list of ids)
            @Query("series") int series,

            // Return only characters which appear the specified series (accepts a comma-separated list of ids)
            @Query("events") int events,

            // Return only characters which appear the specified stories (accepts a comma-separated list of ids)
            @Query("stories") int stories,

            // Order the result set by a field or fields. Add a "-" to the value sort in descending order
            // Values (name, modified, -name, -modified
            @Query("orderBy") String orderBy,

            // Limit the result set to the specified number of resources (default 20)
            @Query("limit") int limit,

            // Skip the specified number of resources in the result set
            @Query("offset") int offset

    );

}
