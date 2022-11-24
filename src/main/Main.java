package main;

import GwentStone.GameplayCommands.*;
import GwentStone.DebugCommands.*;
import GwentStone.StartingTheGame;
import checker.Checker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import checker.CheckerConstants;
import fileio.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * The entry point to this homework. It runs the checker that tests your implentation.
 */
public final class Main {
    /**
     * for coding style
     */
    private Main() {
    }

    /**
     * DO NOT MODIFY MAIN METHOD
     * Call the checker
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(CheckerConstants.TESTS_PATH);
        Path path = Paths.get(CheckerConstants.RESULT_PATH);

        if (Files.exists(path)) {
            File resultFile = new File(String.valueOf(path));
            for (File file : Objects.requireNonNull(resultFile.listFiles())) {
                file.delete();
            }
            resultFile.delete();
        }
        Files.createDirectories(path);

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = CheckerConstants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getName(), filepath);
            }
        }

        Checker.calculateScore();
    }

    /**
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(CheckerConstants.TESTS_PATH + filePath1),
                Input.class);

        ArrayNode output = objectMapper.createArrayNode();

        //TODO add here the entry point to your implementation

        inputData.getPlayerOneDecks().getDecks().get(0).get(0).getName();

        for (int iterator = 0; iterator < inputData.getGames().size(); iterator++) {
            StartingTheGame newgame = new StartingTheGame(inputData, iterator);
            for(int j = 0; j < inputData.getGames().get(iterator).getActions().size(); j++) {
                //pentru fiecare actiune se creaza un nod prin care afisam in output output-ul actiunii
                if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getPlayerDeck")) {
                    PlayerDeck newInstance = new PlayerDeck(inputData.getGames().get(iterator).getActions().get(j), newgame.getDecks(), objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getPlayerHero")) {
                    PlayerHero newInstance = new PlayerHero(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getPlayerTurn")) {
                        PlayerTurn newInstance = new PlayerTurn (inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                        output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("placeCard")) {
                    PlaceCard newInstance = new PlaceCard(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    if(newInstance.isShowError()) {
                        output.add(newInstance.getNode());
                    }
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("endPlayerTurn")) {
                    EndPlayerTurn newInstance = new EndPlayerTurn(newgame);
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getCardsInHand")) {
                    CardsInHand newInstance = new CardsInHand(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getPlayerMana")) {
                    PlayerMana newInstance = new PlayerMana(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getCardsOnTable")) {
                    CardsOnTable newInstance = new CardsOnTable(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getEnvironmentCardsInHand")){
                    EnvironmentCardsInHand newInstance = new EnvironmentCardsInHand(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("useEnvironmentCard")) {
                    EnvironmentCard newInstance = new EnvironmentCard(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    if (newInstance.isShowError()) {
                        output.add(newInstance.getNode());
                    }
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getCardAtPosition")) {
                    CardAtPosition newInstance = new CardAtPosition(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("getFrozenCardsOnTable")) {
                    FrozenCardsOnTable newInstance = new FrozenCardsOnTable(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    output.add(newInstance.getNode());
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("cardUsesAttack")) {
                    CardUsesAttack newInstance = new CardUsesAttack(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    if (newInstance.isShowError()) {
                        output.add(newInstance.getNode());
                    }
                } else if (inputData.getGames().get(iterator).getActions().get(j).getCommand().equals("cardUsesAbility")) {
                    CardUsesAbility newInstance = new CardUsesAbility(inputData.getGames().get(iterator).getActions().get(j), newgame, objectMapper);
                    if (newInstance.isShowError()) {
                        output.add(newInstance.getNode());
                    }
                } else System.out.println("Inca nu ai implementat " + inputData.getGames().get(iterator).getActions().get(j).getCommand());
                //ia frate sa vedem daca merge testam a doua oaraggg
            }
        }

    System.out.println("---END TEST---");

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(filePath2), output);
    }
}
