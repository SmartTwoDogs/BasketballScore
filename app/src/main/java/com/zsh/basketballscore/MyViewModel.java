package com.zsh.basketballscore;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @Description:
 * @Author: 赵少赫
 * @CreateDate: 2021/3/4 9:36 AM
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;

    public MutableLiveData<Integer> getATeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MediatorLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MediatorLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }


    /**
     * A 组记分
     *
     * @param p 得分
     */
    public void addATeam(int p) {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + p);
    }


    /**
     * B 组记分
     *
     * @param p 得分
     */
    public void addBTeam(int p) {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    /**
     * 重置
     */
    public void reset() {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    /**
     * 撤销
     */
    public void undo() {
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }
}
