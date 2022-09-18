package io.tshapeddev.grpc.learnings.repository.impl;

import io.tshapeddev.grpc.learnings.models.Game;
import io.tshapeddev.grpc.learnings.repository.Repository;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class GameRepositoryMapBasedImpl implements Repository<Game> {

    private GameRepositoryMapBasedImpl() {}

    private static volatile Repository<Game> gameRepository = null;

    private final Map<Integer, Game> gameMap = new HashMap<>();

    @Override
    public Game save(@NonNull Game game) {
        return gameMap.put(game.getId(), game);
    }

    @Override
    public Game getById(int gameId) {
        if (!gameMap.containsKey(gameId)) {
            throw new IllegalArgumentException("game with id " + gameId + " does not exist");
        }
        return gameMap.get(gameId);
    }


    public static Repository<Game> getInstance() {
        if (gameRepository == null) {
            synchronized ("gameRepository") {
                if (gameRepository == null) {
                    gameRepository = new GameRepositoryMapBasedImpl();
                }
            }
        }
        return gameRepository;

    }

    @Override
    public boolean isPresent(int id) {
        return gameMap.containsKey(id);
    }
}
