package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p172io.FilenameUtils;
import org.apache.commons.p172io.IOUtils;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

public class PKIXNameConstraintValidator {
    private Set excludedSubtreesDN = new HashSet();
    private Set excludedSubtreesDNS = new HashSet();
    private Set excludedSubtreesEmail = new HashSet();
    private Set excludedSubtreesIP = new HashSet();
    private Set excludedSubtreesURI = new HashSet();
    private Set permittedSubtreesDN;
    private Set permittedSubtreesDNS;
    private Set permittedSubtreesEmail;
    private Set permittedSubtreesIP;
    private Set permittedSubtreesURI;

    private void checkExcludedDN(Set set, ASN1Sequence aSN1Sequence) {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (withinDNSubtree(aSN1Sequence, (ASN1Sequence) it.next())) {
                    throw new PKIXNameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkExcludedDNS(java.util.Set r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Iterator r3 = r3.iterator()
        L_0x000b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r2.withinDomain(r4, r0)
            if (r1 != 0) goto L_0x0024
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0024
            goto L_0x000b
        L_0x0024:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r3 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r4 = "DNS is from an excluded subtree."
            r3.<init>(r4)
            throw r3
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.checkExcludedDNS(java.util.Set, java.lang.String):void");
    }

    private void checkExcludedEmail(Set set, String str) {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (emailIsConstrained(str, (String) it.next())) {
                    throw new PKIXNameConstraintValidatorException("Email address is from an excluded subtree.");
                }
            }
        }
    }

    private void checkExcludedIP(Set set, byte[] bArr) {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isIPConstrained(bArr, (byte[]) it.next())) {
                    throw new PKIXNameConstraintValidatorException("IP is from an excluded subtree.");
                }
            }
        }
    }

    private void checkExcludedURI(Set set, String str) {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isUriConstrained(str, (String) it.next())) {
                    throw new PKIXNameConstraintValidatorException("URI is from an excluded subtree.");
                }
            }
        }
    }

    private void checkPermittedDN(Set set, ASN1Sequence aSN1Sequence) {
        if (set != null) {
            if (!set.isEmpty() || aSN1Sequence.size() != 0) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (withinDNSubtree(aSN1Sequence, (ASN1Sequence) it.next())) {
                        return;
                    }
                }
                throw new PKIXNameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkPermittedDNS(java.util.Set r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Iterator r0 = r4.iterator()
        L_0x0007:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = r3.withinDomain(r5, r1)
            if (r2 != 0) goto L_0x001f
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0007
        L_0x001f:
            return
        L_0x0020:
            int r5 = r5.length()
            if (r5 != 0) goto L_0x002d
            int r4 = r4.size()
            if (r4 != 0) goto L_0x002d
            return
        L_0x002d:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r4 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r5 = "DNS is not from a permitted subtree."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.checkPermittedDNS(java.util.Set, java.lang.String):void");
    }

    private void checkPermittedEmail(Set set, String str) {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (emailIsConstrained(str, (String) it.next())) {
                    return;
                }
            }
            if (str.length() != 0 || set.size() != 0) {
                throw new PKIXNameConstraintValidatorException("Subject email address is not from a permitted subtree.");
            }
        }
    }

    private void checkPermittedIP(Set set, byte[] bArr) {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isIPConstrained(bArr, (byte[]) it.next())) {
                    return;
                }
            }
            if (bArr.length != 0 || set.size() != 0) {
                throw new PKIXNameConstraintValidatorException("IP is not from a permitted subtree.");
            }
        }
    }

    private void checkPermittedURI(Set set, String str) {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isUriConstrained(str, (String) it.next())) {
                    return;
                }
            }
            if (str.length() != 0 || set.size() != 0) {
                throw new PKIXNameConstraintValidatorException("URI is not from a permitted subtree.");
            }
        }
    }

    private boolean collectionsAreEqual(Collection collection, Collection collection2) {
        boolean z;
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (Object next : collection) {
            Iterator it = collection2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (equals(next, it.next())) {
                        z = true;
                        continue;
                        break;
                    }
                } else {
                    z = false;
                    continue;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private static int compareTo(byte[] bArr, byte[] bArr2) {
        if (Arrays.areEqual(bArr, bArr2)) {
            return 0;
        }
        return Arrays.areEqual(max(bArr, bArr2), bArr) ? 1 : -1;
    }

    private boolean emailIsConstrained(String str, String str2) {
        String substring = str.substring(str.indexOf(64) + 1);
        if (str2.indexOf(64) != -1) {
            return str.equalsIgnoreCase(str2) || substring.equalsIgnoreCase(str2.substring(1));
        }
        if (str2.charAt(0) != '.') {
            if (substring.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (withinDomain(substring, str2)) {
            return true;
        }
    }

    private boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) ? obj.equals(obj2) : Arrays.areEqual((byte[]) obj, (byte[]) obj2);
    }

    private static String extractHostFromURL(String str) {
        String substring = str.substring(str.indexOf(58) + 1);
        if (substring.indexOf("//") != -1) {
            substring = substring.substring(substring.indexOf("//") + 2);
        }
        if (substring.lastIndexOf(58) != -1) {
            substring = substring.substring(0, substring.lastIndexOf(58));
        }
        String substring2 = substring.substring(substring.indexOf(58) + 1);
        String substring3 = substring2.substring(substring2.indexOf(64) + 1);
        return substring3.indexOf(47) != -1 ? substring3.substring(0, substring3.indexOf(47)) : substring3;
    }

    private byte[][] extractIPsAndSubnetMasks(byte[] bArr, byte[] bArr2) {
        int length = bArr.length / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, length, bArr4, 0, length);
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, length);
        System.arraycopy(bArr2, length, bArr6, 0, length);
        return new byte[][]{bArr3, bArr4, bArr5, bArr6};
    }

    private String extractNameAsString(GeneralName generalName) {
        return DERIA5String.getInstance(generalName.getName()).getString();
    }

    private int hashCollection(Collection collection) {
        int i = 0;
        if (collection == null) {
            return 0;
        }
        for (Object next : collection) {
            i += next instanceof byte[] ? Arrays.hashCode((byte[]) next) : next.hashCode();
        }
        return i;
    }

    private Set intersectDN(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            ASN1Sequence instance = ASN1Sequence.getInstance(((GeneralSubtree) it.next()).getBase().getName().toASN1Primitive());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) it2.next();
                    if (withinDNSubtree(instance, aSN1Sequence)) {
                        hashSet.add(instance);
                    } else if (withinDNSubtree(aSN1Sequence, instance)) {
                        hashSet.add(aSN1Sequence);
                    }
                }
            } else if (instance != null) {
                hashSet.add(instance);
            }
        }
        return hashSet;
    }

    private Set intersectDNS(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (withinDomain(str, extractNameAsString)) {
                        hashSet.add(str);
                    } else if (withinDomain(extractNameAsString, str)) {
                        hashSet.add(extractNameAsString);
                    }
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private Set intersectEmail(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectEmail(extractNameAsString, (String) it2.next(), hashSet);
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private void intersectEmail(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(substring, str2)) {
                    return;
                }
            } else if (!substring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(".")) {
                if (str2.indexOf(64) != -1) {
                    if (!withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(".")) {
                    if (!withinDomain(str, str2) && !str.equalsIgnoreCase(str2)) {
                        if (!withinDomain(str2, str)) {
                            return;
                        }
                    }
                } else if (!withinDomain(str2, str)) {
                    return;
                }
            } else if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
            set.add(str2);
            return;
        }
        set.add(str);
    }

    private Set intersectIP(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            byte[] octets = ASN1OctetString.getInstance(((GeneralSubtree) it.next()).getBase().getName()).getOctets();
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(intersectIPRange((byte[]) it2.next(), octets));
                }
            } else if (octets != null) {
                hashSet.add(octets);
            }
        }
        return hashSet;
    }

    private Set intersectIPRange(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return Collections.EMPTY_SET;
        }
        byte[][] extractIPsAndSubnetMasks = extractIPsAndSubnetMasks(bArr, bArr2);
        byte[] bArr3 = extractIPsAndSubnetMasks[0];
        byte[] bArr4 = extractIPsAndSubnetMasks[1];
        byte[] bArr5 = extractIPsAndSubnetMasks[2];
        byte[] bArr6 = extractIPsAndSubnetMasks[3];
        byte[][] minMaxIPs = minMaxIPs(bArr3, bArr4, bArr5, bArr6);
        return compareTo(max(minMaxIPs[0], minMaxIPs[2]), min(minMaxIPs[1], minMaxIPs[3])) == 1 ? Collections.EMPTY_SET : Collections.singleton(ipWithSubnetMask(m9222or(minMaxIPs[0], minMaxIPs[2]), m9222or(bArr4, bArr6)));
    }

    private Set intersectURI(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectURI((String) it2.next(), extractNameAsString, hashSet);
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private void intersectURI(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(substring, str2)) {
                    return;
                }
            } else if (!substring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(".")) {
                if (str2.indexOf(64) != -1) {
                    if (!withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(".")) {
                    if (!withinDomain(str, str2) && !str.equalsIgnoreCase(str2)) {
                        if (!withinDomain(str2, str)) {
                            return;
                        }
                    }
                } else if (!withinDomain(str2, str)) {
                    return;
                }
            } else if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
            set.add(str2);
            return;
        }
        set.add(str);
    }

    private byte[] ipWithSubnetMask(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[(length * 2)];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr2, 0, bArr3, length, length);
        return bArr3;
    }

    private boolean isIPConstrained(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr4[i] = (byte) (bArr2[i] & bArr3[i]);
            bArr5[i] = (byte) (bArr[i] & bArr3[i]);
        }
        return Arrays.areEqual(bArr4, bArr5);
    }

    private boolean isUriConstrained(String str, String str2) {
        String extractHostFromURL = extractHostFromURL(str);
        return !str2.startsWith(".") ? extractHostFromURL.equalsIgnoreCase(str2) : withinDomain(extractHostFromURL, str2);
    }

    private static byte[] max(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 65535) > (65535 & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    private static byte[] min(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 65535) < (65535 & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    private byte[][] minMaxIPs(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int length = bArr.length;
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        byte[] bArr7 = new byte[length];
        byte[] bArr8 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr5[i] = (byte) (bArr[i] & bArr2[i]);
            bArr6[i] = (byte) ((bArr[i] & bArr2[i]) | (~bArr2[i]));
            bArr7[i] = (byte) (bArr3[i] & bArr4[i]);
            bArr8[i] = (byte) ((bArr3[i] & bArr4[i]) | (~bArr4[i]));
        }
        return new byte[][]{bArr5, bArr6, bArr7, bArr8};
    }

    /* renamed from: or */
    private static byte[] m9222or(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] | bArr2[i]);
        }
        return bArr3;
    }

    private String stringifyIP(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length / 2; i++) {
            str = str + Integer.toString(bArr[i] & 255) + ".";
        }
        String str2 = str.substring(0, str.length() - 1) + "/";
        for (int length = bArr.length / 2; length < bArr.length; length++) {
            str2 = str2 + Integer.toString(bArr[length] & 255) + ".";
        }
        return str2.substring(0, str2.length() - 1);
    }

    private String stringifyIPCollection(Set set) {
        String str = "" + "[";
        Iterator it = set.iterator();
        while (it.hasNext()) {
            str = str + stringifyIP((byte[]) it.next()) + ",";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        return str + "]";
    }

    private Set unionDN(Set set, ASN1Sequence aSN1Sequence) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) it.next();
                if (withinDNSubtree(aSN1Sequence, aSN1Sequence2)) {
                    hashSet.add(aSN1Sequence2);
                } else {
                    if (!withinDNSubtree(aSN1Sequence2, aSN1Sequence)) {
                        hashSet.add(aSN1Sequence2);
                    }
                    hashSet.add(aSN1Sequence);
                }
            }
            return hashSet;
        } else if (aSN1Sequence == null) {
            return set;
        } else {
            set.add(aSN1Sequence);
            return set;
        }
    }

    private Set unionEmail(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                unionEmail((String) it.next(), str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (withinDomain(r5.substring(r4.indexOf(64) + 1), r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (withinDomain(r5, r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (withinDomain(r5, r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if (r5.substring(r4.indexOf(64) + 1).equalsIgnoreCase(r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        if (withinDomain(r4, r5) != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        if (r4.equalsIgnoreCase(r5) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r4.equalsIgnoreCase(r5) != false) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void unionEmail(java.lang.String r4, java.lang.String r5, java.util.Set r6) {
        /*
            r3 = this;
            r0 = 64
            int r1 = r4.indexOf(r0)
            r2 = -1
            if (r1 == r2) goto L_0x0039
            int r1 = r4.indexOf(r0)
            int r1 = r1 + 1
            java.lang.String r1 = r4.substring(r1)
            int r0 = r5.indexOf(r0)
            if (r0 == r2) goto L_0x0021
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0021:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0031
            boolean r0 = r3.withinDomain(r1, r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a0
        L_0x0031:
            boolean r0 = r1.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a0
        L_0x0039:
            java.lang.String r1 = "."
            boolean r1 = r4.startsWith(r1)
            if (r1 == 0) goto L_0x007b
            int r1 = r5.indexOf(r0)
            if (r1 == r2) goto L_0x0058
            int r0 = r4.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            boolean r0 = r3.withinDomain(r0, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0058:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0074
            boolean r0 = r3.withinDomain(r4, r5)
            if (r0 != 0) goto L_0x00ae
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x006d
            goto L_0x00ae
        L_0x006d:
            boolean r0 = r3.withinDomain(r5, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0074:
            boolean r0 = r3.withinDomain(r5, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x007b:
            int r1 = r5.indexOf(r0)
            if (r1 == r2) goto L_0x0092
            int r0 = r4.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0092:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x00a1
            boolean r0 = r3.withinDomain(r4, r5)
            if (r0 == 0) goto L_0x00ab
        L_0x00a0:
            goto L_0x00ae
        L_0x00a1:
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
        L_0x00a7:
            r6.add(r4)
            goto L_0x00b1
        L_0x00ab:
            r6.add(r4)
        L_0x00ae:
            r6.add(r5)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.unionEmail(java.lang.String, java.lang.String, java.util.Set):void");
    }

    private Set unionIP(Set set, byte[] bArr) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.addAll(unionIPRange((byte[]) it.next(), bArr));
            }
            return hashSet;
        } else if (bArr == null) {
            return set;
        } else {
            set.add(bArr);
            return set;
        }
    }

    private Set unionIPRange(byte[] bArr, byte[] bArr2) {
        HashSet hashSet = new HashSet();
        if (Arrays.areEqual(bArr, bArr2)) {
            hashSet.add(bArr);
        } else {
            hashSet.add(bArr);
            hashSet.add(bArr2);
        }
        return hashSet;
    }

    private Set unionURI(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                unionURI((String) it.next(), str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (withinDomain(r5.substring(r4.indexOf(64) + 1), r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (withinDomain(r5, r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (withinDomain(r5, r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if (r5.substring(r4.indexOf(64) + 1).equalsIgnoreCase(r4) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        if (withinDomain(r4, r5) != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        if (r4.equalsIgnoreCase(r5) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r4.equalsIgnoreCase(r5) != false) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void unionURI(java.lang.String r4, java.lang.String r5, java.util.Set r6) {
        /*
            r3 = this;
            r0 = 64
            int r1 = r4.indexOf(r0)
            r2 = -1
            if (r1 == r2) goto L_0x0039
            int r1 = r4.indexOf(r0)
            int r1 = r1 + 1
            java.lang.String r1 = r4.substring(r1)
            int r0 = r5.indexOf(r0)
            if (r0 == r2) goto L_0x0021
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0021:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0031
            boolean r0 = r3.withinDomain(r1, r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a0
        L_0x0031:
            boolean r0 = r1.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a0
        L_0x0039:
            java.lang.String r1 = "."
            boolean r1 = r4.startsWith(r1)
            if (r1 == 0) goto L_0x007b
            int r1 = r5.indexOf(r0)
            if (r1 == r2) goto L_0x0058
            int r0 = r4.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            boolean r0 = r3.withinDomain(r0, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0058:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x0074
            boolean r0 = r3.withinDomain(r4, r5)
            if (r0 != 0) goto L_0x00ae
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x006d
            goto L_0x00ae
        L_0x006d:
            boolean r0 = r3.withinDomain(r5, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0074:
            boolean r0 = r3.withinDomain(r5, r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x007b:
            int r1 = r5.indexOf(r0)
            if (r1 == r2) goto L_0x0092
            int r0 = r4.indexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x00ab
            goto L_0x00a7
        L_0x0092:
            java.lang.String r0 = "."
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L_0x00a1
            boolean r0 = r3.withinDomain(r4, r5)
            if (r0 == 0) goto L_0x00ab
        L_0x00a0:
            goto L_0x00ae
        L_0x00a1:
            boolean r0 = r4.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00ab
        L_0x00a7:
            r6.add(r4)
            goto L_0x00b1
        L_0x00ab:
            r6.add(r4)
        L_0x00ae:
            r6.add(r5)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.unionURI(java.lang.String, java.lang.String, java.util.Set):void");
    }

    private static boolean withinDNSubtree(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.size() < 1 || aSN1Sequence2.size() > aSN1Sequence.size()) {
            return false;
        }
        for (int size = aSN1Sequence2.size() - 1; size >= 0; size--) {
            if (!aSN1Sequence2.getObjectAt(size).equals(aSN1Sequence.getObjectAt(size))) {
                return false;
            }
        }
        return true;
    }

    private boolean withinDomain(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        String[] split = Strings.split(str2, FilenameUtils.EXTENSION_SEPARATOR);
        String[] split2 = Strings.split(str, FilenameUtils.EXTENSION_SEPARATOR);
        if (split2.length <= split.length) {
            return false;
        }
        int length = split2.length - split.length;
        for (int i = -1; i < split.length; i++) {
            if (i == -1) {
                if (split2[i + length].equals("")) {
                    return false;
                }
            } else if (!split[i].equalsIgnoreCase(split2[i + length])) {
                return false;
            }
        }
        return true;
    }

    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        GeneralName base = generalSubtree.getBase();
        switch (base.getTagNo()) {
            case 1:
                this.excludedSubtreesEmail = unionEmail(this.excludedSubtreesEmail, extractNameAsString(base));
                return;
            case 2:
                this.excludedSubtreesDNS = unionDNS(this.excludedSubtreesDNS, extractNameAsString(base));
                return;
            case 4:
                this.excludedSubtreesDN = unionDN(this.excludedSubtreesDN, (ASN1Sequence) base.getName().toASN1Primitive());
                return;
            case 6:
                this.excludedSubtreesURI = unionURI(this.excludedSubtreesURI, extractNameAsString(base));
                return;
            case 7:
                this.excludedSubtreesIP = unionIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(base.getName()).getOctets());
                return;
            default:
                return;
        }
    }

    public void checkExcluded(GeneralName generalName) {
        switch (generalName.getTagNo()) {
            case 1:
                checkExcludedEmail(this.excludedSubtreesEmail, extractNameAsString(generalName));
                return;
            case 2:
                checkExcludedDNS(this.excludedSubtreesDNS, DERIA5String.getInstance(generalName.getName()).getString());
                return;
            case 4:
                checkExcludedDN(ASN1Sequence.getInstance(generalName.getName().toASN1Primitive()));
                return;
            case 6:
                checkExcludedURI(this.excludedSubtreesURI, DERIA5String.getInstance(generalName.getName()).getString());
                return;
            case 7:
                checkExcludedIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(generalName.getName()).getOctets());
                return;
            default:
                return;
        }
    }

    public void checkExcludedDN(ASN1Sequence aSN1Sequence) {
        checkExcludedDN(this.excludedSubtreesDN, aSN1Sequence);
    }

    public void checkPermitted(GeneralName generalName) {
        switch (generalName.getTagNo()) {
            case 1:
                checkPermittedEmail(this.permittedSubtreesEmail, extractNameAsString(generalName));
                return;
            case 2:
                checkPermittedDNS(this.permittedSubtreesDNS, DERIA5String.getInstance(generalName.getName()).getString());
                return;
            case 4:
                checkPermittedDN(ASN1Sequence.getInstance(generalName.getName().toASN1Primitive()));
                return;
            case 6:
                checkPermittedURI(this.permittedSubtreesURI, DERIA5String.getInstance(generalName.getName()).getString());
                return;
            case 7:
                checkPermittedIP(this.permittedSubtreesIP, ASN1OctetString.getInstance(generalName.getName()).getOctets());
                return;
            default:
                return;
        }
    }

    public void checkPermittedDN(ASN1Sequence aSN1Sequence) {
        checkPermittedDN(this.permittedSubtreesDN, aSN1Sequence);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        return collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesDN, this.excludedSubtreesDN) && collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesDNS, this.excludedSubtreesDNS) && collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesEmail, this.excludedSubtreesEmail) && collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesIP, this.excludedSubtreesIP) && collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesURI, this.excludedSubtreesURI) && collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesDN, this.permittedSubtreesDN) && collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesDNS, this.permittedSubtreesDNS) && collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesEmail, this.permittedSubtreesEmail) && collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesIP, this.permittedSubtreesIP) && collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesURI, this.permittedSubtreesURI);
    }

    public int hashCode() {
        return hashCollection(this.excludedSubtreesDN) + hashCollection(this.excludedSubtreesDNS) + hashCollection(this.excludedSubtreesEmail) + hashCollection(this.excludedSubtreesIP) + hashCollection(this.excludedSubtreesURI) + hashCollection(this.permittedSubtreesDN) + hashCollection(this.permittedSubtreesDNS) + hashCollection(this.permittedSubtreesEmail) + hashCollection(this.permittedSubtreesIP) + hashCollection(this.permittedSubtreesURI);
    }

    public void intersectEmptyPermittedSubtree(int i) {
        switch (i) {
            case 1:
                this.permittedSubtreesEmail = new HashSet();
                return;
            case 2:
                this.permittedSubtreesDNS = new HashSet();
                return;
            case 4:
                this.permittedSubtreesDN = new HashSet();
                return;
            case 6:
                this.permittedSubtreesURI = new HashSet();
                return;
            case 7:
                this.permittedSubtreesIP = new HashSet();
                return;
            default:
                return;
        }
    }

    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        intersectPermittedSubtree(new GeneralSubtree[]{generalSubtree});
    }

    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i != generalSubtreeArr.length; i++) {
            GeneralSubtree generalSubtree = generalSubtreeArr[i];
            Integer valueOf = Integers.valueOf(generalSubtree.getBase().getTagNo());
            if (hashMap.get(valueOf) == null) {
                hashMap.put(valueOf, new HashSet());
            }
            ((Set) hashMap.get(valueOf)).add(generalSubtree);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            switch (((Integer) entry.getKey()).intValue()) {
                case 1:
                    this.permittedSubtreesEmail = intersectEmail(this.permittedSubtreesEmail, (Set) entry.getValue());
                    break;
                case 2:
                    this.permittedSubtreesDNS = intersectDNS(this.permittedSubtreesDNS, (Set) entry.getValue());
                    break;
                case 4:
                    this.permittedSubtreesDN = intersectDN(this.permittedSubtreesDN, (Set) entry.getValue());
                    break;
                case 6:
                    this.permittedSubtreesURI = intersectURI(this.permittedSubtreesURI, (Set) entry.getValue());
                    break;
                case 7:
                    this.permittedSubtreesIP = intersectIP(this.permittedSubtreesIP, (Set) entry.getValue());
                    break;
            }
        }
    }

    public String toString() {
        String str = "" + "permitted:\n";
        if (this.permittedSubtreesDN != null) {
            str = (str + "DN:\n") + this.permittedSubtreesDN.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (this.permittedSubtreesDNS != null) {
            str = (str + "DNS:\n") + this.permittedSubtreesDNS.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (this.permittedSubtreesEmail != null) {
            str = (str + "Email:\n") + this.permittedSubtreesEmail.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (this.permittedSubtreesURI != null) {
            str = (str + "URI:\n") + this.permittedSubtreesURI.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (this.permittedSubtreesIP != null) {
            str = (str + "IP:\n") + stringifyIPCollection(this.permittedSubtreesIP) + IOUtils.LINE_SEPARATOR_UNIX;
        }
        String str2 = str + "excluded:\n";
        if (!this.excludedSubtreesDN.isEmpty()) {
            str2 = (str2 + "DN:\n") + this.excludedSubtreesDN.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (!this.excludedSubtreesDNS.isEmpty()) {
            str2 = (str2 + "DNS:\n") + this.excludedSubtreesDNS.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (!this.excludedSubtreesEmail.isEmpty()) {
            str2 = (str2 + "Email:\n") + this.excludedSubtreesEmail.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (!this.excludedSubtreesURI.isEmpty()) {
            str2 = (str2 + "URI:\n") + this.excludedSubtreesURI.toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        if (this.excludedSubtreesIP.isEmpty()) {
            return str2;
        }
        return (str2 + "IP:\n") + stringifyIPCollection(this.excludedSubtreesIP) + IOUtils.LINE_SEPARATOR_UNIX;
    }

    /* access modifiers changed from: protected */
    public Set unionDNS(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!withinDomain(str2, str)) {
                    if (withinDomain(str, str2)) {
                        hashSet.add(str2);
                    } else {
                        hashSet.add(str2);
                    }
                }
                hashSet.add(str);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }
}
