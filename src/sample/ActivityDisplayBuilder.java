package sample;

/**
 * Created by ecogle on 3/14/2017.
 */
public class ActivityDisplayBuilder extends ActivityBuilder {
        ActivityDisplay ad;

        public ActivityDisplayBuilder setClassName(String s){
            this.ad.setClassName(s);
            return this;
        }

        public ActivityDisplay build(){
            return this.ad;
        }

}
