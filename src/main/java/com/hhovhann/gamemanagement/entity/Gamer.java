package com.hhovhann.gamemanagement.entity;

import com.hhovhann.gamemanagement.entity.data.Geography;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Gamer implements Serializable {

    @Serial
    private static final long serialVersionUID = -7254728412209071436L;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "gamer_seq")
    @SequenceGenerator(allocationSize = 90, name = "gamer_seq", sequenceName = "gamer_sequence")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @Embedded
    @NotNull
    private Geography geography;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", foreignKey = @ForeignKey(name = "fk_gamer_game_id"))
    private Game game;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Geography getGeography() {
        return geography;
    }

    public void setGeography(Geography geography) {
        this.geography = geography;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        return id != null && id.equals(((Gamer) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
