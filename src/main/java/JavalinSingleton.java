

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
            
            //implement logic here
            String jsonStr = ctx.body(); // Getting user json request
            Song userSong = om.readValue(jsonStr, Song.class); // Turning json to a song object
            ctx.json(userSong); // Retutn to user as a json string

        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            //implement logic here
            String jsonStr = ctx.body();
            Song userSong = om.readValue(jsonStr, Song.class);
            userSong.setArtistName("Beatles"); // changing artist name to Beatles
            ctx.json(userSong);
        });


        return app;
    }
    
}
