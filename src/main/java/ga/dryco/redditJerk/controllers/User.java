package ga.dryco.redditJerk.controllers;

import java.util.List;
import java.util.Objects;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.Sorting;
import ga.dryco.redditJerk.datamodels.T2Data;


public class User extends T2Data {

    private Reddit rApi = RedditApi.getRedditInstance();

    public Overview getOverview(Integer limit, Sorting sort)  {
        return rApi.getOverview(super.getName(), limit, sort);
    }

    public List<Link> getSubmitted(Integer limit)  {
       return rApi.getUserSubmissions(super.getName(), limit, Sorting.NEW);
    }

    public List<Link> getSubmitted(Integer limit, Sorting sort)  {
        return rApi.getUserSubmissions(super.getName(), limit, sort);
    }

    public List<Comment> getComments(Integer limit)  {
        return rApi.getUserComments(super.getName(), limit, Sorting.NEW);
    }


    public List<Comment> getComments(Integer limit, Sorting sort)  {
        return rApi.getUserComments(super.getName(), limit, sort);
    }

    public List<Link> getHidden(Integer limit){
        return rApi.getUserHidden(super.getName(), limit);
    }

    public List<Link> getUpvoted(Integer limit){
        return rApi.getUserUpvoted(super.getName(), limit);
    }

    public List<Link> getDownvoted(Integer limit){
        return rApi.getUserDownvoted(super.getName(), limit);
    }

    public List<Comment> getGilded(Integer limit){ return rApi.getUserGilded(super.getName(), limit);
    }

    /**
     * Extra utility functions
     */

    public Integer getKarmaBalance(String subreddit, Integer limit)  {
        Integer karma = 0;
        for(Comment comm: this.getComments(limit)){
            if(Objects.equals(comm.getSubreddit(), subreddit)){
                karma = karma + comm.getScore();
            }

        }

        for(Link subm:this.getSubmitted(limit)){
            if(Objects.equals(subm.getSubreddit(), subreddit)){
                karma = karma + subm.getScore();
            }
            }

        return karma;
    }



}
