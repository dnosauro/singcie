package com.cyberneid.p089b.p091b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.parse.ParseException;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

/* renamed from: com.cyberneid.b.b.i */
public final class C1490i extends C1483b {

    /* renamed from: a */
    private static final C1490i f4448a = new C1490i();

    static {
        f4448a.mo7052a(0, 0, ".notdef");
        f4448a.mo7052a(1, 1, "space");
        f4448a.mo7052a(2, 2, "exclam");
        f4448a.mo7052a(3, 3, "quotedbl");
        f4448a.mo7052a(4, 4, "numbersign");
        f4448a.mo7052a(5, 5, "dollar");
        f4448a.mo7052a(6, 6, "percent");
        f4448a.mo7052a(7, 7, "ampersand");
        f4448a.mo7052a(8, 8, "quoteright");
        f4448a.mo7052a(9, 9, "parenleft");
        f4448a.mo7052a(10, 10, "parenright");
        f4448a.mo7052a(11, 11, "asterisk");
        f4448a.mo7052a(12, 12, "plus");
        f4448a.mo7052a(13, 13, "comma");
        f4448a.mo7052a(14, 14, "hyphen");
        f4448a.mo7052a(15, 15, "period");
        f4448a.mo7052a(16, 16, "slash");
        f4448a.mo7052a(17, 17, "zero");
        f4448a.mo7052a(18, 18, "one");
        f4448a.mo7052a(19, 19, "two");
        f4448a.mo7052a(20, 20, "three");
        f4448a.mo7052a(21, 21, "four");
        f4448a.mo7052a(22, 22, "five");
        f4448a.mo7052a(23, 23, "six");
        f4448a.mo7052a(24, 24, "seven");
        f4448a.mo7052a(25, 25, "eight");
        f4448a.mo7052a(26, 26, "nine");
        f4448a.mo7052a(27, 27, "colon");
        f4448a.mo7052a(28, 28, "semicolon");
        f4448a.mo7052a(29, 29, "less");
        f4448a.mo7052a(30, 30, "equal");
        f4448a.mo7052a(31, 31, "greater");
        f4448a.mo7052a(32, 32, "question");
        f4448a.mo7052a(33, 33, "at");
        f4448a.mo7052a(34, 34, "A");
        f4448a.mo7052a(35, 35, "B");
        f4448a.mo7052a(36, 36, "C");
        f4448a.mo7052a(37, 37, "D");
        f4448a.mo7052a(38, 38, "E");
        f4448a.mo7052a(39, 39, "F");
        f4448a.mo7052a(40, 40, "G");
        f4448a.mo7052a(41, 41, "H");
        f4448a.mo7052a(42, 42, "I");
        f4448a.mo7052a(43, 43, "J");
        f4448a.mo7052a(44, 44, "K");
        f4448a.mo7052a(45, 45, "L");
        f4448a.mo7052a(46, 46, "M");
        f4448a.mo7052a(47, 47, "N");
        f4448a.mo7052a(48, 48, "O");
        f4448a.mo7052a(49, 49, "P");
        f4448a.mo7052a(50, 50, "Q");
        f4448a.mo7052a(51, 51, "R");
        f4448a.mo7052a(52, 52, "S");
        f4448a.mo7052a(53, 53, "T");
        f4448a.mo7052a(54, 54, "U");
        f4448a.mo7052a(55, 55, "V");
        f4448a.mo7052a(56, 56, "W");
        f4448a.mo7052a(57, 57, "X");
        f4448a.mo7052a(58, 58, "Y");
        f4448a.mo7052a(59, 59, "Z");
        f4448a.mo7052a(60, 60, "bracketleft");
        f4448a.mo7052a(61, 61, "backslash");
        f4448a.mo7052a(62, 62, "bracketright");
        f4448a.mo7052a(63, 63, "asciicircum");
        f4448a.mo7052a(64, 64, "underscore");
        f4448a.mo7052a(65, 65, "quoteleft");
        f4448a.mo7052a(66, 66, "a");
        f4448a.mo7052a(67, 67, "b");
        f4448a.mo7052a(68, 68, "c");
        f4448a.mo7052a(69, 69, "d");
        f4448a.mo7052a(70, 70, "e");
        f4448a.mo7052a(71, 71, "f");
        f4448a.mo7052a(72, 72, "g");
        f4448a.mo7052a(73, 73, "h");
        f4448a.mo7052a(74, 74, "i");
        f4448a.mo7052a(75, 75, "j");
        f4448a.mo7052a(76, 76, "k");
        f4448a.mo7052a(77, 77, "l");
        f4448a.mo7052a(78, 78, "m");
        f4448a.mo7052a(79, 79, "n");
        f4448a.mo7052a(80, 80, "o");
        f4448a.mo7052a(81, 81, "p");
        f4448a.mo7052a(82, 82, "q");
        f4448a.mo7052a(83, 83, "r");
        f4448a.mo7052a(84, 84, "s");
        f4448a.mo7052a(85, 85, "t");
        f4448a.mo7052a(86, 86, "u");
        f4448a.mo7052a(87, 87, "v");
        f4448a.mo7052a(88, 88, "w");
        f4448a.mo7052a(89, 89, "x");
        f4448a.mo7052a(90, 90, "y");
        f4448a.mo7052a(91, 91, "z");
        f4448a.mo7052a(92, 92, "braceleft");
        f4448a.mo7052a(93, 93, "bar");
        f4448a.mo7052a(94, 94, "braceright");
        f4448a.mo7052a(95, 95, "asciitilde");
        f4448a.mo7052a(96, 96, "exclamdown");
        f4448a.mo7052a(97, 97, "cent");
        f4448a.mo7052a(98, 98, "sterling");
        f4448a.mo7052a(99, 99, "fraction");
        f4448a.mo7052a(100, 100, "yen");
        f4448a.mo7052a(101, 101, "florin");
        f4448a.mo7052a(102, 102, "section");
        f4448a.mo7052a(103, 103, FirebaseAnalytics.Param.CURRENCY);
        f4448a.mo7052a(104, 104, "quotesingle");
        f4448a.mo7052a(105, 105, "quotedblleft");
        f4448a.mo7052a(106, 106, "guillemotleft");
        f4448a.mo7052a(107, 107, "guilsinglleft");
        f4448a.mo7052a(108, 108, "guilsinglright");
        f4448a.mo7052a(109, 109, "fi");
        f4448a.mo7052a(110, 110, "fl");
        f4448a.mo7052a(111, 111, "endash");
        f4448a.mo7052a(112, 112, "dagger");
        f4448a.mo7052a(113, 113, "daggerdbl");
        f4448a.mo7052a(114, 114, "periodcentered");
        f4448a.mo7052a(115, 115, "paragraph");
        f4448a.mo7052a(116, 116, "bullet");
        f4448a.mo7052a(117, 117, "quotesinglbase");
        f4448a.mo7052a(118, 118, "quotedblbase");
        f4448a.mo7052a(119, 119, "quotedblright");
        f4448a.mo7052a(120, 120, "guillemotright");
        f4448a.mo7052a(121, 121, "ellipsis");
        f4448a.mo7052a(122, 122, "perthousand");
        f4448a.mo7052a(123, 123, "questiondown");
        f4448a.mo7052a(124, 124, "grave");
        f4448a.mo7052a(ParseException.INVALID_EMAIL_ADDRESS, ParseException.INVALID_EMAIL_ADDRESS, "acute");
        f4448a.mo7052a(126, 126, "circumflex");
        f4448a.mo7052a(CertificateBody.profileType, CertificateBody.profileType, "tilde");
        f4448a.mo7052a(128, 128, "macron");
        f4448a.mo7052a(129, 129, "breve");
        f4448a.mo7052a(130, 130, "dotaccent");
        f4448a.mo7052a(131, 131, "dieresis");
        f4448a.mo7052a(CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, "ring");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, "cedilla");
        f4448a.mo7052a(CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, "hungarumlaut");
        f4448a.mo7052a(135, 135, "ogonek");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, "caron");
        f4448a.mo7052a(137, 137, "emdash");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, "AE");
        f4448a.mo7052a(139, 139, "ordfeminine");
        f4448a.mo7052a(140, 140, "Lslash");
        f4448a.mo7052a(141, 141, "Oslash");
        f4448a.mo7052a(142, 142, "OE");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, "ordmasculine");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, "ae");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, "dotlessi");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, "lslash");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, "oslash");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, "oe");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, "germandbls");
        f4448a.mo7052a(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, "onesuperior");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, "logicalnot");
        f4448a.mo7052a(CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, "mu");
        f4448a.mo7052a(153, 153, "trademark");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, "Eth");
        f4448a.mo7052a(155, 155, "onehalf");
        f4448a.mo7052a(CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, "plusminus");
        f4448a.mo7052a(CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, "Thorn");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, "onequarter");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, "divide");
        f4448a.mo7052a(160, 160, "brokenbar");
        f4448a.mo7052a(CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, "degree");
        f4448a.mo7052a(CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, "thorn");
        f4448a.mo7052a(CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, "threequarters");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, "twosuperior");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, "registered");
        f4448a.mo7052a(CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, "minus");
        f4448a.mo7052a(CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, "eth");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, "multiply");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, "threesuperior");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, "copyright");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, "Aacute");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, "Acircumflex");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, "Adieresis");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, "Agrave");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, "Aring");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_NULL_SHA256, CipherSuite.TLS_PSK_WITH_NULL_SHA256, "Atilde");
        f4448a.mo7052a(CipherSuite.TLS_PSK_WITH_NULL_SHA384, CipherSuite.TLS_PSK_WITH_NULL_SHA384, "Ccedilla");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, "Eacute");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, "Ecircumflex");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, "Edieresis");
        f4448a.mo7052a(CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, "Egrave");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, "Iacute");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, "Icircumflex");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA256, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA256, "Idieresis");
        f4448a.mo7052a(CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, "Igrave");
        f4448a.mo7052a(CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, "Ntilde");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, "Oacute");
        f4448a.mo7052a(188, 188, "Ocircumflex");
        f4448a.mo7052a(CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, "Odieresis");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, "Ograve");
        f4448a.mo7052a(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, "Otilde");
        f4448a.mo7052a(192, 192, "Scaron");
        f4448a.mo7052a(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, "Uacute");
        f4448a.mo7052a(CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, "Ucircumflex");
        f4448a.mo7052a(CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, "Udieresis");
        f4448a.mo7052a(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, "Ugrave");
        f4448a.mo7052a(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, "Yacute");
        f4448a.mo7052a(198, 198, "Ydieresis");
        f4448a.mo7052a(199, 199, "Zcaron");
        f4448a.mo7052a(200, 200, "aacute");
        f4448a.mo7052a(ParseException.PASSWORD_MISSING, ParseException.PASSWORD_MISSING, "acircumflex");
        f4448a.mo7052a(ParseException.USERNAME_TAKEN, ParseException.USERNAME_TAKEN, "adieresis");
        f4448a.mo7052a(ParseException.EMAIL_TAKEN, ParseException.EMAIL_TAKEN, "agrave");
        f4448a.mo7052a(ParseException.EMAIL_MISSING, ParseException.EMAIL_MISSING, "aring");
        f4448a.mo7052a(ParseException.EMAIL_NOT_FOUND, ParseException.EMAIL_NOT_FOUND, "atilde");
        f4448a.mo7052a(ParseException.SESSION_MISSING, ParseException.SESSION_MISSING, "ccedilla");
        f4448a.mo7052a(ParseException.MUST_CREATE_USER_THROUGH_SIGNUP, ParseException.MUST_CREATE_USER_THROUGH_SIGNUP, "eacute");
        f4448a.mo7052a(ParseException.ACCOUNT_ALREADY_LINKED, ParseException.ACCOUNT_ALREADY_LINKED, "ecircumflex");
        f4448a.mo7052a(ParseException.INVALID_SESSION_TOKEN, ParseException.INVALID_SESSION_TOKEN, "edieresis");
        f4448a.mo7052a(210, 210, "egrave");
        f4448a.mo7052a(Primes.SMALL_FACTOR_LIMIT, Primes.SMALL_FACTOR_LIMIT, "iacute");
        f4448a.mo7052a(212, 212, "icircumflex");
        f4448a.mo7052a(213, 213, "idieresis");
        f4448a.mo7052a(214, 214, "igrave");
        f4448a.mo7052a(215, 215, "ntilde");
        f4448a.mo7052a(216, 216, "oacute");
        f4448a.mo7052a(217, 217, "ocircumflex");
        f4448a.mo7052a(218, 218, "odieresis");
        f4448a.mo7052a(219, 219, "ograve");
        f4448a.mo7052a(220, 220, "otilde");
        f4448a.mo7052a(221, 221, "scaron");
        f4448a.mo7052a(222, 222, "uacute");
        f4448a.mo7052a(223, 223, "ucircumflex");
        f4448a.mo7052a(224, 224, "udieresis");
        f4448a.mo7052a(225, 225, "ugrave");
        f4448a.mo7052a(226, 226, "yacute");
        f4448a.mo7052a(227, 227, "ydieresis");
        f4448a.mo7052a(228, 228, "zcaron");
    }

    private C1490i() {
        super(false);
    }

    /* renamed from: a */
    public static C1490i m5681a() {
        return f4448a;
    }
}