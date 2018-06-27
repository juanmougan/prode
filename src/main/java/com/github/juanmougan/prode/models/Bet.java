package com.github.juanmougan.prode.models;

import javax.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Match match;
    private Result result;
    @ManyToOne
    private Person player;
    private Boolean played;
    private Boolean counted;
    private Integer pointsWon = 0;

    public Bet() {
    }

    public Bet(Match match, Result result, Person player, Boolean played, Boolean counted, Integer pointsWon) {
        this.match = match;
        this.result = result;
        this.player = player;
        this.played = played;
        this.counted = counted;
        this.pointsWon = pointsWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (id != null ? !id.equals(bet.id) : bet.id != null) return false;
        if (match != null ? !match.equals(bet.match) : bet.match != null) return false;
        if (result != bet.result) return false;
        if (player != null ? !player.equals(bet.player) : bet.player != null) return false;
        if (played != null ? !played.equals(bet.played) : bet.played != null) return false;
        if (counted != null ? !counted.equals(bet.counted) : bet.counted != null) return false;
        return pointsWon != null ? pointsWon.equals(bet.pointsWon) : bet.pointsWon == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (match != null ? match.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (player != null ? player.hashCode() : 0);
        result1 = 31 * result1 + (played != null ? played.hashCode() : 0);
        result1 = 31 * result1 + (counted != null ? counted.hashCode() : 0);
        result1 = 31 * result1 + (pointsWon != null ? pointsWon.hashCode() : 0);
        return result1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Boolean getPlayed() {
        return played;
    }

    public void setPlayed(Boolean played) {
        this.played = played;
    }

    public Boolean getCounted() {
        return counted;
    }

    public void setCounted(Boolean counted) {
        this.counted = counted;
    }

    public Integer getPointsWon() {
        return pointsWon;
    }

    public void setPointsWon(Integer pointsWon) {
        this.pointsWon = pointsWon;
    }
}
