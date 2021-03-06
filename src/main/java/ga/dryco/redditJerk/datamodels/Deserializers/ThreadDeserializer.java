package ga.dryco.redditJerk.datamodels.Deserializers;

import java.lang.reflect.Type;

import ga.dryco.redditJerk.controllers.RedditThread;
import ga.dryco.redditJerk.datamodels.T1Listing;
import ga.dryco.redditJerk.datamodels.T3;

/**
 *
 *
 */
public class ThreadDeserializer implements JsonDeserializer<RedditThread> {
    public RedditThread deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        RedditThread returnthread = new RedditThread();
        JsonArray threadarray = json.getAsJsonArray();
        if(threadarray.size() != 2){
            throw new JsonParseException(json.toString());
        }
        //doing the Post part of the thread
        JsonArray postobj = threadarray.get(0).getAsJsonObject().get("data").getAsJsonObject().getAsJsonArray("children");
        returnthread.setSubmissionPost(context.deserialize(postobj.get(0), T3.class));

        JsonObject comlisting = threadarray.get(1).getAsJsonObject();
        JsonArray commarr = comlisting.get("data").getAsJsonObject().getAsJsonArray("children");
        if(commarr.size() > 0){
            returnthread.setComments(context.deserialize(comlisting, T1Listing.class));
        }

        return returnthread;

    }

}
