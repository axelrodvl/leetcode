package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reward-top-k-students/
 */
class RewardTopKStudents {
    @Test
    void topStudentsTest() {
        assertEquals(Arrays.asList(1, 2),
                topStudents(
                        new String[]{"smart", "brilliant", "studious"},
                        new String[]{"not"},
                        new String[]{
                                "this student is studious",
                                "the student is smart"
                        },
                        new int[]{1, 2},
                        2
                )
        );

        assertEquals(Arrays.asList(2, 1),
                topStudents(
                        new String[]{"smart", "brilliant", "studious"},
                        new String[]{"not"},
                        new String[]{
                                "this student is not studious",
                                "the student is smart"
                        },
                        new int[]{1, 2},
                        2
                )
        );

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                topStudents(
                        new String[]{"+", "+", "+"},
                        new String[]{"-", "-", "-", "-", "-"},
                        new String[]{
                                "+ + - + - + -",
                                "+ + + + + - + -",
                                "+ + - + - +",
                                "- - + + - + + -",
                                "+ + + - + +",
                                "+ + - - +",
                                "+ - - + - - - +",
                                "+ + + + + +",
                                "+ + +"
                        },
                        new int[]{6, 2, 4, 7, 3, 8, 9, 1, 5},
                        9
                )
        );

        assertEquals(Arrays.asList(865635090, 934288178, 864052244, 625397331, 281613863, 686276715, 519945877, 971253305, 512505036),
                topStudents(
                        new String[]{"xrezzxgdvg", "bcgx", "wcfzmfosr"},
                        new String[]{"qyouhus", "ukou", "eirhfbt", "qciw", "for"},
                        new String[]{
                                "bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw",
                                "bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw",
                                "xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr",
                                "for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt",
                                "loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg",
                                "rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx",
                                "bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg",
                                "bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr",
                                "qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"
                        },
                        new int[]{686276715, 934288178, 625397331, 519945877, 864052244, 971253305, 512505036, 865635090, 281613863},
                        9
                )
        );
    }

    public List<Integer> topStudents(
            String[] positive_feedback,
            String[] negative_feedback,
            String[] report,
            int[] student_id,
            int k) {
        Set<String> positive = new HashSet<>(List.of(positive_feedback));
        Set<String> negative = new HashSet<>(List.of(negative_feedback));

        List<StudentRating> studentRatings = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            int rating = 0;
            for (String reportPart : report[i].split(" ")) {
                if (positive.contains(reportPart)) {
                    rating += 3;
                } else if (negative.contains(reportPart)) {
                    rating -= 1;
                }
            }
            studentRatings.add(new StudentRating(student_id[i], rating));
        }
        Comparator<StudentRating> ratingComparator = Comparator.comparingInt(x -> x.rating);
        Comparator<StudentRating> reversedRatingComparator = ratingComparator.reversed();

        Comparator<StudentRating> idComparator = Comparator.comparingInt(x -> x.studentId);

        studentRatings.sort(reversedRatingComparator.thenComparing(idComparator));

        return studentRatings.subList(0, k).stream().map(x -> x.studentId).collect(Collectors.toList());
    }

    static class StudentRating {
        StudentRating(int studentId, int rating) {
            this.studentId = studentId;
            this.rating = rating;
        }

        int studentId;
        int rating;
    }
}
