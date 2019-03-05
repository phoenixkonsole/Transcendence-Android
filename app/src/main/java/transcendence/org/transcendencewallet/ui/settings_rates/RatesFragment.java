package transcendence.org.transcendencewallet.ui.settings_rates;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import transcendence.org.transcendencewallet.R;
import global.TranscendenceRate;
import transcendence.org.transcendencewallet.ui.base.BaseRecyclerFragment;
import transcendence.org.transcendencewallet.ui.base.tools.adapter.BaseRecyclerAdapter;
import transcendence.org.transcendencewallet.ui.base.tools.adapter.BaseRecyclerViewHolder;
import transcendence.org.transcendencewallet.ui.base.tools.adapter.ListItemListeners;

/**
 * Created by akshaynexus on 7/2/17.
 */

public class RatesFragment extends BaseRecyclerFragment<TranscendenceRate> implements ListItemListeners<TranscendenceRate> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setEmptyText("No rate available");
        setEmptyTextColor(Color.parseColor("#cccccc"));
        return view;
    }

    @Override
    protected List<TranscendenceRate> onLoading() {
        return transcendenceModule.listRates();
    }

    @Override
    protected BaseRecyclerAdapter<TranscendenceRate, ? extends TranscendenceRateHolder> initAdapter() {
        BaseRecyclerAdapter<TranscendenceRate, TranscendenceRateHolder> adapter = new BaseRecyclerAdapter<TranscendenceRate, TranscendenceRateHolder>(getActivity()) {
            @Override
            protected TranscendenceRateHolder createHolder(View itemView, int type) {
                return new TranscendenceRateHolder(itemView,type);
            }

            @Override
            protected int getCardViewResource(int type) {
                return R.layout.rate_row;
            }

            @Override
            protected void bindHolder(TranscendenceRateHolder holder, TranscendenceRate data, int position) {
                holder.txt_name.setText(data.getCode());
                if (list.get(0).getCode().equals(data.getCode()))
                    holder.view_line.setVisibility(View.GONE);
            }
        };
        adapter.setListEventListener(this);
        return adapter;
    }

    @Override
    public void onItemClickListener(TranscendenceRate data, int position) {
        transcendenceApplication.getAppConf().setSelectedRateCoin(data.getCode());
        Toast.makeText(getActivity(),R.string.rate_selected,Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    @Override
    public void onLongItemClickListener(TranscendenceRate data, int position) {

    }

    private  class TranscendenceRateHolder extends BaseRecyclerViewHolder{

        private TextView txt_name;
        private View view_line;

        protected TranscendenceRateHolder(View itemView, int holderType) {
            super(itemView, holderType);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            view_line = itemView.findViewById(R.id.view_line);
        }
    }
}
