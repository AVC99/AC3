package Renderer;

import Business.Pokemon;
import edu.salleurl.profile.Profileable;
import edu.salleurl.profile.renderer.ProfileRendererFactory;

public class HTMLPokemonRender {
    private Profileable profileable;
    private ProfileRendererFactory profileRendererFactory;

    public HTMLPokemonRender(){

    }

    public void render(String url){
        ProfileRendererFactory.createHTMLProfileRenderer(url);
    }
}
