package software.credible.mcfinder.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import software.credible.mcfinder.R;
import software.credible.mcfinder.remote.dto.MarvelCharacter;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.MarvelCharacterHolder> {
    private LayoutInflater layoutInflater;
    private List<MarvelCharacter> characters = new ArrayList<>();

    public CharacterListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MarvelCharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.character_list_item, parent, false);
        MarvelCharacterHolder marvelCharacterHolder = new MarvelCharacterHolder(view);
        return marvelCharacterHolder;
    }

    @Override
    public void onBindViewHolder(MarvelCharacterHolder holder, int position) {
        MarvelCharacter character = characters.get(position);
        holder.setDetails(character.getDescription());
        holder.setSummary(character.getName());
    }

    public void addCharacter(MarvelCharacter character) {
        if(this.characters == null) {
            this.characters = new ArrayList<>();
        }
        characters.add(character);
     }

    @Override
    public int getItemCount() {
        return characters == null ? 0 : characters.size();
    }

    public static class MarvelCharacterHolder extends RecyclerView.ViewHolder {
        private TextView summary;
        private TextView details;

        public MarvelCharacterHolder(View itemView) {
            super(itemView);
            summary = (TextView) itemView.findViewById(R.id.summary);
            details = (TextView) itemView.findViewById(R.id.details);
        }

        public void setSummary(String text) {
            summary.setText(text);
        }

        public void setDetails(String text) {
            details.setText(text);
        }
    }
}
