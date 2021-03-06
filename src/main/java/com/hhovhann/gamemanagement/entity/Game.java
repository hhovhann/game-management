package com.hhovhann.gamemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {

    private static final long serialVersionUID = -9131478947119037529L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "game_seq")
    @SequenceGenerator(allocationSize = 70, name = "game_seq", sequenceName = "game_sequence")
    private Long id;

    @NotBlank
    String name;

    @OneToMany(mappedBy = "game", cascade = { PERSIST, MERGE}, fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        return id != null && id.equals(((Game) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
