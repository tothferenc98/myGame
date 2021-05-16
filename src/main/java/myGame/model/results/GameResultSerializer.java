package myGame.model.results;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GameResultSerializer {

    public static void serialize(myGame.model.results.GameResult gameResult) {

        List<myGame.model.results.GameResult> gameResultList = myGame.model.results.GameResultDeserializer.deserialize();
        try {
            File file = new File("./test.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fileWriter);
            for(myGame.model.results.GameResult gameResult1: gameResultList){
                sequenceWriter.write(gameResult1);
            }
            sequenceWriter.write(gameResult);
            sequenceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
