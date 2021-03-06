package ga.dryco.redditJerk.datamodels.Deserializers;

import java.lang.reflect.Type;

import ga.dryco.redditJerk.controllers.Link;
import ga.dryco.redditJerk.datamodels.T3;

/**
 * t3 deserializer:
 * if "edited" is boolean remove it
 */
public class T3Deserializer implements JsonDeserializer<T3> {
    public T3 deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context){
        JsonObject jsonData = json.getAsJsonObject().get("data").getAsJsonObject();
        JsonElement edited = jsonData.get("edited");
        if (edited != null && edited.isJsonPrimitive()){
            JsonPrimitive primitiv = edited.getAsJsonPrimitive();
            if (primitiv.isBoolean()) {
                jsonData.remove("edited");
            }
        }
        T3 t3 = new T3();
        Link t3Data = context.deserialize(jsonData, Link.class);
        t3.setData(t3Data);

        return t3;

    }

}
