package leetcode;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Date: 2019-01-02
 * Title: Unique Email Addresses
 * Url: https://leetcode.com/problems/unique-email-addresses/
 * Description:
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address,
 * mail sent there will be forwarded to the same address without dots in the local name.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.)
 * It is possible to use both of these rules at the same time.
 * Given a list of emails, we send one email to each address in the list.
 * How many different addresses actually receive mails?
 * <p>
 * Example :
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * <p>
 * Note:
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 */
public class _929_UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Pattern COMPILE = Pattern.compile(".", Pattern.LITERAL);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String s = emails[i];
            int at = s.indexOf('@');
            String local = s.substring(0, at);
            String domain = s.substring(at);
            int plus = local.indexOf('+');
            if (plus >= 0)
                local = local.substring(0, plus);
            set.add(COMPILE.matcher(local).replaceAll("") + domain);
        }
        return set.size();
    }

    @Test
    public void test() {
        assertEquals(2, numUniqueEmails(
                new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"}));
        assertEquals(2, numUniqueEmails(
                new String[]{"fg.r.u.uzj+o.pw@kziczvh.com", "r.cyo.g+d.h+b.ja@tgsg.z.com",
                        "fg.r.u.uzj+o.f.d@kziczvh.com", "r.cyo.g+ng.r.iq@tgsg.z.com", "fg.r.u.uzj+lp.k@kziczvh.com",
                        "r.cyo.g+n.h.e+n.g@tgsg.z.com", "fg.r.u.uzj+k+p.j@kziczvh.com", "fg.r.u.uzj+w.y+b@kziczvh.com",
                        "r.cyo.g+x+d.c+f.t@tgsg.z.com", "r.cyo.g+x+t.y.l.i@tgsg.z.com", "r.cyo.g+brxxi@tgsg.z.com",
                        "r.cyo.g+z+dr.k.u@tgsg.z.com", "r.cyo.g+d+l.c.n+g@tgsg.z.com", "fg.r.u.uzj+vq.o@kziczvh.com",
                        "fg.r.u.uzj+uzq@kziczvh.com", "fg.r.u.uzj+mvz@kziczvh.com", "fg.r.u.uzj+taj@kziczvh.com",
                        "fg.r.u.uzj+fek@kziczvh.com"
                }));
    }

}
