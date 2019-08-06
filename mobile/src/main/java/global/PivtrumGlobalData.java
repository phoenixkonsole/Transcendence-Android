package global;

import java.util.ArrayList;
import java.util.List;

import pivtrum.PivtrumPeerData;

/**
 * Created by akshaynexus on 7/2/17.
 */

public class PivtrumGlobalData {

    public static final String FURSZY_TESTNET_SERVER = "144.76.99.135";

    public static final String[] TRUSTED_NODES = new String[]{"94.130.206.190","178.63.67.11","5.9.32.209","173.249.59.202","149.28.207.67","144.76.154.137"
    };

    public static final List<PivtrumPeerData> listTrustedHosts(){
        List<PivtrumPeerData> list = new ArrayList<>();
        list.add(new PivtrumPeerData(FURSZY_TESTNET_SERVER,8051,55552));
        for (String trustedNode : TRUSTED_NODES) {
            list.add(new PivtrumPeerData(trustedNode,8051,55552));
        }
        return list;
    }

}
