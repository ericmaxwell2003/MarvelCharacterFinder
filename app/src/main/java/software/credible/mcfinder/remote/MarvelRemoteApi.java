package software.credible.mcfinder.remote;

import java.util.Date;

import retrofit.http.GET;
import retrofit.http.Query;
import software.credible.mcfinder.remote.dto.MarvelResultWrapper;

public interface MarvelRemoteApi {

    @GET("/characters")
    MarvelResultWrapper fetchAllCharacters();

}
