import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 11007139 on 12.10.2017.
 */
class PersonTest {

        @Test
        void marry() {
            Person m = new Person(true, "m");
            Person w = new Person(false, "w");

            assertTrue(m.marry(w));
            assertEquals(w, m.spouse);
            assertEquals(m, w.spouse);
        }

        @Test
        void divorce() {
            Person m = new Person(true, "m");
            assertFalse(m.divorce());

            Person w = new Person(false, "w");
            m.marry(w);

            assertTrue(m.divorce());

            assertNull(m.spouse);
            assertNull(w.spouse);
        }

        @Test
        public void testMerryWithDivorce() {
            Person m1 = new Person(true, "m");
            Person w1 = new Person(false, "w");
            m1.marry(w1);

            Person m2 = new Person(true, "m2");
            Person w2 = new Person(false, "w2");
            w2.marry(m2);

            assertTrue(w1.marry(m2));

            assertNull(m1.spouse);
            assertNull(w2.spouse);
            assertEquals(m2, w1.spouse);
            assertEquals(w1, m2.spouse);

            assertFalse(w1.marry(m2));
        }

        @Test
        public void testMarryPersonsWithSameGender() {
            testMarryPersonsWithSameGender(true);
            testMarryPersonsWithSameGender(false);
        }

        private void testMarryPersonsWithSameGender(boolean gender) {
            Person p1 = new Person(gender, "A");
            Person p2 = new Person(gender, "B");

            assertFalse(p1.marry(p2));
            assertFalse(p2.marry(p1));
        }

    }



