package com.yurii.rps.springboot_rest_rps;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// @RequestMapping("/api/v1")
@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);
    // static Score score = new Score(0, 0, 0);

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore) {
        score = newScore;
        return score;
    }

    @DeleteMapping("/score")
    public Score deleteScore() {
        score = new Score(0, 0, 0);
        return score;
    }

    @PatchMapping("/score/wins")
    public Score patchWins(@RequestParam(name="new-value", defaultValue="0") int newValue) {
        score.setWins(newValue);
        return score;
    }

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal All Fired Up!"; 
    }

    @PostMapping("/score/wins")
    public Score increaseWins() {
        score.setWins(score.getWins() + 1);
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies() {
        score.setTies(score.getTies() + 1);
        return score;
    }
    @PostMapping("/score/losses")
    public Score increaseLosses() {
        score.setLosses(score.getLosses() + 1);
        return score;
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @GetMapping("/score/{winstieslosses}")
    public int getScoreByType(@PathVariable String winstieslosses) {
        //ignore case
        winstieslosses = winstieslosses.toLowerCase();
        switch (winstieslosses) {
            case "wins":
                return score.getWins();
            case "ties":
                return score.getTies();
            case "losses":
                return score.getLosses();
            default:
                throw new IllegalArgumentException("Invalid type: " + winstieslosses);
        }
    }

}
