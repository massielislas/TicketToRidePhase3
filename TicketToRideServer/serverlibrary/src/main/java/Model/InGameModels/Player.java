package Model.InGameModels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.UserPass;

/**
 * Created by Master_Chief on 5/23/2018.
 */

public class Player {
    private UserPass userName;
    private List<TrainCard> trainCards;
    private List<DestinationCard> destCards;
    private Set<Route> routesClaimed;
    int turnNumber;
    int trainPiecesLeft;

    public Player(UserPass name, int queuePosition) {
        userName = name;
        trainCards = new ArrayList<>();
        destCards = new ArrayList<>();
        routesClaimed = new HashSet<>();
        turnNumber = queuePosition;
        trainPiecesLeft = 45;
    }

    public UserPass getUserName() {
        return userName;
    }

    public void setUserName(UserPass userName) {
        this.userName = userName;
    }

    public List<TrainCard> getTrainCards() {
        return trainCards;
    }

    public void setTrainCards(List<TrainCard> trainCards) {
        this.trainCards = trainCards;
    }

    public List<DestinationCard> getDestCards() {
        return destCards;
    }

    public void setDestCards(List<DestinationCard> destCards) {
        this.destCards = destCards;
    }

    public Set<Route> getRoutesClaimed() {
        return routesClaimed;
    }

    public void setRoutesClaimed(Set<Route> routesClaimed) {
        this.routesClaimed = routesClaimed;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTrainPiecesLeft() {
        return trainPiecesLeft;
    }

    public void setTrainPiecesLeft(int trainPiecesLeft) {
        this.trainPiecesLeft = trainPiecesLeft;
    }
}
