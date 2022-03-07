package com.hhovhann.gamemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhovhann.gamemanagement.entity.data.GameLevel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = -9131478947119037529L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "game_seq")
    @SequenceGenerator(allocationSize = 70, name = "game_seq", sequenceName = "game_sequence")
    private Long id;

    @NotNull
    String name;

    @Enumerated(STRING)
    @NotNull
    private GameLevel gameLevel;

    @OneToMany(mappedBy = "gamer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Gamer> gamers = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public void setGamers(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public void addGamer(Gamer gamer) {
        gamers.add(gamer);
        gamer.setGame(this);
    }

    public void removeGamer(Gamer gamer) {
        gamers.remove(gamer);
        gamer.setGame(null);
    }
}
