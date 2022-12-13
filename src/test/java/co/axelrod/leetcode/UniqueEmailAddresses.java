package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
class UniqueEmailAddresses {
    @Test
    void numUniqueEmailsTest() {
        assertEquals(2, numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        }));

        assertEquals(3, numUniqueEmails(new String[]{
                "a@leetcode.com",
                "b@leetcode.com",
                "c@leetcode.com"
        }));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            char[] tokens = new char[email.length()];
            int length = 0;

            boolean skip = false;
            boolean atOccurred = false;
            for (int i = 0; i < email.length(); i++) {
                char current = email.charAt(i);

                if (current == '+') {
                    skip = true;
                } else if (current == '@') {
                    skip = false;
                    atOccurred = true;
                } else if (current == '.' && !atOccurred) {
                    continue;
                }

                if (!skip) {
                    tokens[length++] = current;
                }
            }
            uniqueEmails.add(new String(tokens, 0, length));
        }

        return uniqueEmails.size();
    }
}
