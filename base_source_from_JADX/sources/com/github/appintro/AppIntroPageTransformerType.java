package com.github.appintro;

public abstract class AppIntroPageTransformerType {

    public static final class Depth extends AppIntroPageTransformerType {
        public static final Depth INSTANCE = new Depth();

        private Depth() {
            super((C3247e) null);
        }
    }

    public static final class Fade extends AppIntroPageTransformerType {
        public static final Fade INSTANCE = new Fade();

        private Fade() {
            super((C3247e) null);
        }
    }

    public static final class Flow extends AppIntroPageTransformerType {
        public static final Flow INSTANCE = new Flow();

        private Flow() {
            super((C3247e) null);
        }
    }

    public static final class Parallax extends AppIntroPageTransformerType {
        private final double descriptionParallaxFactor;
        private final double imageParallaxFactor;
        private final double titleParallaxFactor;

        public Parallax() {
            this(0.0d, 0.0d, 0.0d, 7, (C3247e) null);
        }

        public Parallax(double d, double d2, double d3) {
            super((C3247e) null);
            this.titleParallaxFactor = d;
            this.imageParallaxFactor = d2;
            this.descriptionParallaxFactor = d3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parallax(double d, double d2, double d3, int i, C3247e eVar) {
            this((i & 1) != 0 ? 1.0d : d, (i & 2) != 0 ? -1.0d : d2, (i & 4) != 0 ? 2.0d : d3);
        }

        public final double getDescriptionParallaxFactor() {
            return this.descriptionParallaxFactor;
        }

        public final double getImageParallaxFactor() {
            return this.imageParallaxFactor;
        }

        public final double getTitleParallaxFactor() {
            return this.titleParallaxFactor;
        }
    }

    public static final class SlideOver extends AppIntroPageTransformerType {
        public static final SlideOver INSTANCE = new SlideOver();

        private SlideOver() {
            super((C3247e) null);
        }
    }

    public static final class Zoom extends AppIntroPageTransformerType {
        public static final Zoom INSTANCE = new Zoom();

        private Zoom() {
            super((C3247e) null);
        }
    }

    private AppIntroPageTransformerType() {
    }

    public /* synthetic */ AppIntroPageTransformerType(C3247e eVar) {
        this();
    }
}
