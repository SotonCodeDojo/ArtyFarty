package ga.dryco.redditJerk.datamodels;

import java.util.List;

/**
 * This is a weird listing that doesn't include "after" and "before" so no need to extend ListingData
 */
public class ModeratorsListingData {

    public List<ModeratorsData> getChildren() {
        return children;
    }

    public void setChildren(List<ModeratorsData> children) {
        this.children = children;
    }

    @Expose
    private List<ModeratorsData> children;

}
