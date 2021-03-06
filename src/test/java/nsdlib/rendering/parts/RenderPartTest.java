package nsdlib.rendering.parts;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import nsdlib.elements.NSDElement;
import nsdlib.elements.NSDInstruction;
import nsdlib.rendering.RenderColor;


public class RenderPartTest
{
    @Test
    public void storesSource()
    {
        NSDElement source = new NSDInstruction("source");
        assertSame(source, new MockRenderPart(source).getSource());

        assertNull(new MockRenderPart().getSource());
    }

    @Test
    public void findsForSource()
    {
        NSDElement source = new NSDInstruction("source");
        MockRenderPart part = new MockRenderPart(source);

        assertSame(part, part.findForSource(source));

        assertNull(part.findForSource(new NSDInstruction("other")));
    }

    @Test
    public void setsBackground()
    {
        NSDElement source = new NSDInstruction("source");
        MockRenderPart part = new MockRenderPart(source);

        assertNull(part.getBackground());

        RenderColor bg = new RenderColor(37, 42, 47);
        part.setBackground(bg);
        assertSame(bg, part.getBackground());

        part.setBackground(null);
        assertNull(part.getBackground());
    }
}
