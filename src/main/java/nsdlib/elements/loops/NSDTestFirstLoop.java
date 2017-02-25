package nsdlib.elements.loops;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import nsdlib.elements.NSDContainer;
import nsdlib.elements.NSDElement;
import nsdlib.rendering.parts.BraceRenderPart;
import nsdlib.rendering.parts.RenderPart;


/**
 * Represents a loop element that first checks its condition before the inner
 * elements are run (i.e. a {@code while} loop).
 */
public class NSDTestFirstLoop extends NSDContainer<NSDElement>
{
    /**
     * @param label The element's label.
     */
    public NSDTestFirstLoop(String label)
    {
        super(label);
    }

    /**
     * @param label The element's label.
     * @param children The element's initial child elements.
     */
    public NSDTestFirstLoop(String label,
            Collection<? extends NSDElement> children)
    {
        super(label, children);
    }

    @Override
    public RenderPart toRenderPart()
    {
        List<RenderPart> children = stream().map(e -> e.toRenderPart())
                .collect(Collectors.toList());

        return new BraceRenderPart(children, true, getLabel(), false, null);
    }
}
