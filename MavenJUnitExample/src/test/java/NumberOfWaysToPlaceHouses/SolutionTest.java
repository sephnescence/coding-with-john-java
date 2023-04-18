package NumberOfWaysToPlaceHouses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countHousePlacements() {
        Solution solution = new Solution();

        int placementsWhereNEqualsOneThousand = solution.countHousePlacements(1000);
        assertEquals(500478595, placementsWhereNEqualsOneThousand);

//        int placementsWhereNEqualsOneHundredThousand = solution.countHousePlacements(100000);
//        assertEquals(933156416, placementsWhereNEqualsOneHundredThousand);
        // So supposedly that returns 543442386, but 1000 also returns 500478595, There is certainly not
        // only 40M more spaces, yeah? It's jumping from 500M to only 543M... Something seems off
        // I didn't read instructions omg hahahahahaha

//        int placementsWhereNEqualsOne = solution.countHousePlacements(1);
//        assertEquals(4, placementsWhereNEqualsOne);
//
//        int placementsWhereNEqualsTwo = solution.countHousePlacements(2);
//        assertEquals(9, placementsWhereNEqualsTwo);

    }
    void dontCountHousePlacements() {
        Solution solution = new Solution();
        int placementsWhereNEqualsOne = solution.countHousePlacements(1);
        /* So imagine the street looking like this. You have four states
        [p1]
        ---
        [p2]
        - No houses placed either side
        - A house in p1 and no house in p2
        - No house in p1 and a house in p2
        - A house in both p1 and p2
         */
        assertEquals(4, placementsWhereNEqualsOne);

        int placementsWhereNEqualsTwo = solution.countHousePlacements(2);
        /* 
        [p1] [p2]
        ---------
        [p3] [p4]
        - p1 n p2 n p3 n p4 n
        
        - p1 y p2 n p3 n p4 n
        - p1 n p2 y p3 n p4 n
        - p1 n p2 n p3 y p4 n
        - p1 n p2 n p3 n p4 y
        
        - p1 y p2 n p3 y p4 n
        - p1 y p2 n p3 n p4 y
        - p1 n p2 y p3 y p4 n
        - p1 n p2 y p3 n p4 n
         */
        assertEquals(9, placementsWhereNEqualsOne);

        int placementsWhereNEqualsThree = solution.countHousePlacements(3);
        /* At this point I'm thinking it's possible to only calculate one side of the road
        It's the same amount of plots on the other side
        
        So in this case it's 25
        [p1] [p2] [p3]
        --------------
        [p4] [p5] [p6]
        01 - p1 n p2 n p3 n
        02 - p1 y p2 n p3 n
        03 - p1 n p2 y p3 n
        04 - p1 n p2 n p3 y
        05 - p1 y p2 n p3 y
         */
        assertEquals(25, placementsWhereNEqualsOne);

        /*
        [p1] [p2] [p3] [p4]
        001 - [ ] [ ] [ ] [ ]
        002 - [Y] [ ] [ ] [ ]
        003 - [ ] [Y] [ ] [ ]
        004 - [ ] [ ] [Y] [ ]
        005 - [ ] [ ] [ ] [Y]
        006 - [Y] [ ] [Y] [ ]
        007 - [Y] [ ] [ ] [Y]
        008 - [ ] [Y] [ ] [Y]
         */

        /*
        [p1] [p2] [p3] [p4] [p5]
        001 - [ ] [ ] [ ] [ ] [ ]
        002 - [Y] [ ] [ ] [ ] [ ]
        003 - [ ] [Y] [ ] [ ] [ ]
        004 - [ ] [ ] [Y] [ ] [ ]
        005 - [ ] [ ] [ ] [Y] [ ]
        006 - [ ] [ ] [ ] [ ] [Y]
        007 - [Y] [ ] [Y] [ ] [ ]
        008 - [Y] [ ] [ ] [Y] [ ]
        009 - [Y] [ ] [ ] [ ] [Y]
        010 - [ ] [Y] [ ] [Y] [ ]
        011 - [ ] [Y] [ ] [ ] [Y]
        012 - [ ] [ ] [Y] [ ] [Y]
        013 - [Y] [ ] [Y] [ ] [Y]
         */



        /*
        (can place 1 houses in 1 spots = 2 arrangements)
        (can place 1 houses in 2 spots = 3 arrangements)
        (can place 2 houses in 3 spots = 5 arrangements)
        (can place 2 houses in 4 spots = 8 arrangements)
        (can place 3 houses in 5 spots = 13 arrangements)
        (can place 3 houses in 6 spots = 21 arrangements)
        (can place 4 houses in 7 spots = 34 arrangements) -- Interesting that this is essentially the fibonacci sequence, without the leading 0, 1, 1
        (can place 4 houses in 8 spots = 55 arrangements) -- defs fibonacci
        [p1] [p2] [p3] [p4] [p5] [p6]
        001 - [ ] [ ] [ ] [ ] [ ] [ ]
        002 - [Y] [ ] [ ] [ ] [ ] [ ]
        003 - [ ] [Y] [ ] [ ] [ ] [ ]
        004 - [ ] [ ] [Y] [ ] [ ] [ ]
        005 - [ ] [ ] [ ] [Y] [ ] [ ]
        006 - [ ] [ ] [ ] [ ] [Y] [ ]
        007 - [ ] [ ] [ ] [ ] [ ] [Y]
        008 - [Y] [ ] [Y] [ ] [ ] [ ]
        009 - [Y] [ ] [ ] [Y] [ ] [ ]
        010 - [Y] [ ] [ ] [ ] [Y] [ ]
        011 - [Y] [ ] [ ] [ ] [ ] [Y]
        012 - [ ] [Y] [ ] [Y] [ ] [ ]
        013 - [ ] [Y] [ ] [ ] [Y] [ ]
        014 - [ ] [Y] [ ] [ ] [ ] [Y]
        015 - [ ] [ ] [Y] [ ] [Y] [ ]
        016 - [ ] [ ] [Y] [ ] [ ] [Y]
        017 - [ ] [ ] [ ] [Y] [ ] [Y]
        018 - [Y] [ ] [Y] [ ] [Y] [ ]
        019 - [Y] [ ] [Y] [ ] [ ] [Y]
        020 - [Y] [ ] [ ] [Y] [ ] [Y]
        021 - [ ] [Y] [ ] [Y] [ ] [Y]
         */

        /*
        [p1] [p2] [p3] [p4] [p5] [p6] [p7]
        001 - [ ] [ ] [ ] [ ] [ ] [ ] [ ]
        002 - [Y] [ ] [ ] [ ] [ ] [ ] [ ]
        003 - [ ] [Y] [ ] [ ] [ ] [ ] [ ]
        004 - [ ] [ ] [Y] [ ] [ ] [ ] [ ]
        005 - [ ] [ ] [ ] [Y] [ ] [ ] [ ]
        006 - [ ] [ ] [ ] [ ] [Y] [ ] [ ]
        007 - [ ] [ ] [ ] [ ] [ ] [Y] [ ]
        008 - [ ] [ ] [ ] [ ] [ ] [ ] [Y]
        009 - [Y] [ ] [Y] [ ] [ ] [ ] [ ]
        010 - [Y] [ ] [ ] [Y] [ ] [ ] [ ]
        011 - [Y] [ ] [ ] [ ] [Y] [ ] [ ]
        012 - [Y] [ ] [ ] [ ] [ ] [Y] [ ]
        013 - [Y] [ ] [ ] [ ] [ ] [ ] [Y]
        014 - [ ] [Y] [ ] [Y] [ ] [ ] [ ]
        015 - [ ] [Y] [ ] [ ] [Y] [ ] [ ]
        016 - [ ] [Y] [ ] [ ] [ ] [Y] [ ]
        017 - [ ] [Y] [ ] [ ] [ ] [ ] [Y]
        018 - [ ] [ ] [Y] [ ] [Y] [ ] [ ]
        019 - [ ] [ ] [Y] [ ] [ ] [Y] [ ]
        020 - [ ] [ ] [Y] [ ] [ ] [ ] [Y]
        021 - [ ] [ ] [ ] [Y] [ ] [Y] [ ]
        022 - [ ] [ ] [ ] [Y] [ ] [ ] [Y]
        023 - [ ] [ ] [ ] [ ] [Y] [ ] [Y]
        024 - [Y] [ ] [Y] [ ] [Y] [ ] [ ] -- inverse of 33
        025 - [Y] [ ] [Y] [ ] [ ] [Y] [ ] -- inverse of 32
        026 - [Y] [ ] [Y] [ ] [ ] [ ] [Y] -- inverse of 28
        027 - [Y] [ ] [ ] [Y] [ ] [ ] [Y] -- no inverse cos it's even
        028 - [Y] [ ] [ ] [ ] [Y] [ ] [Y] -- inverse of 26
        029 - [Y] [ ] [ ] [Y] [ ] [Y] [ ] -- inverse of 31
        030 - [ ] [Y] [ ] [Y] [ ] [Y] [ ] -- no inverse cos it's even
        031 - [ ] [Y] [ ] [Y] [ ] [ ] [Y] -- inverse of 29
        032 - [ ] [Y] [ ] [ ] [Y] [ ] [Y] -- inverse of 25
        033 - [ ] [ ] [Y] [ ] [Y] [ ] [Y] -- inverse of 24
        034 - [Y] [ ] [Y] [ ] [Y] [ ] [Y] -- no inverse cos it's even
         */

        int placementsWhereNEqualsEight = solution.countHousePlacements(8);
        /*
        So in this case it's ???
        [p1] [p2] [p3] [p4] [p5] [p6] [p7] [p8]
        001 - [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]

        One house per
        002 - [Y] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
        003 - [ ] [Y] [ ] [ ] [ ] [ ] [ ] [ ]
        004 - [ ] [ ] [Y] [ ] [ ] [ ] [ ] [ ]
        005 - [ ] [ ] [ ] [Y] [ ] [ ] [ ] [ ]
        006 - [ ] [ ] [ ] [ ] [Y] [ ] [ ] [ ]
        007 - [ ] [ ] [ ] [ ] [ ] [Y] [ ] [ ]
        008 - [ ] [ ] [ ] [ ] [ ] [ ] [Y] [ ]
        009 - [ ] [ ] [ ] [ ] [ ] [ ] [ ] [Y]

        Two houses per
        010 - [Y] [ ] [Y] [ ] [ ] [ ] [ ] [ ]
        011 - [Y] [ ] [ ] [Y] [ ] [ ] [ ] [ ]
        012 - [Y] [ ] [ ] [ ] [Y] [ ] [ ] [ ]
        013 - [Y] [ ] [ ] [ ] [ ] [Y] [ ] [ ]
        014 - [Y] [ ] [ ] [ ] [ ] [ ] [Y] [ ]
        015 - [Y] [ ] [ ] [ ] [ ] [ ] [ ] [Y]
        016 - [ ] [Y] [ ] [Y] [ ] [ ] [ ] [ ]
        017 - [ ] [Y] [ ] [ ] [Y] [ ] [ ] [ ]
        018 - [ ] [Y] [ ] [ ] [ ] [Y] [ ] [ ]
        019 - [ ] [Y] [ ] [ ] [ ] [ ] [Y] [ ]
        020 - [ ] [Y] [ ] [ ] [ ] [ ] [ ] [Y]
        021 - [ ] [ ] [Y] [ ] [Y] [ ] [ ] [ ]
        022 - [ ] [ ] [Y] [ ] [ ] [Y] [ ] [ ]
        023 - [ ] [ ] [Y] [ ] [ ] [ ] [Y] [ ]
        024 - [ ] [ ] [Y] [ ] [ ] [ ] [ ] [Y]
        025 - [ ] [ ] [ ] [Y] [ ] [Y] [ ] [ ]
        026 - [ ] [ ] [ ] [Y] [ ] [ ] [Y] [ ]
        027 - [ ] [ ] [ ] [Y] [ ] [ ] [ ] [Y]
        028 - [ ] [ ] [ ] [ ] [Y] [ ] [Y] [ ]
        029 - [ ] [ ] [ ] [ ] [Y] [ ] [ ] [Y]
        030 - [ ] [ ] [ ] [ ] [ ] [Y] [ ] [Y]

        Three houses per
        031 - [Y] [ ] [Y] [ ] [Y] [ ] [ ] [ ]
        032 - [Y] [ ] [Y] [ ] [ ] [Y] [ ] [ ]
        033 - [Y] [ ] [Y] [ ] [ ] [ ] [Y] [ ]
        034 - [Y] [ ] [Y] [ ] [ ] [ ] [ ] [Y]
        035 - [Y] [ ] [ ] [Y] [ ] [Y] [ ] [ ]
        036 - [Y] [ ] [ ] [Y] [ ] [ ] [Y] [ ]
        037 - [Y] [ ] [ ] [Y] [ ] [ ] [ ] [Y]
        038 - [Y] [ ] [ ] [ ] [Y] [ ] [Y] [ ]
        039 - [Y] [ ] [ ] [ ] [Y] [ ] [ ] [Y]
        040 - [Y] [ ] [ ] [ ] [ ] [Y] [ ] [Y]
        041 - [ ] [Y] [ ] [Y] [ ] [Y] [ ] [ ]
        042 - [ ] [Y] [ ] [Y] [ ] [ ] [Y] [ ]
        043 - [ ] [Y] [ ] [Y] [ ] [ ] [ ] [Y]
        044 - [ ] [Y] [ ] [ ] [Y] [ ] [Y] [ ]
        045 - [ ] [Y] [ ] [ ] [Y] [ ] [ ] [Y]
        046 - [ ] [Y] [ ] [ ] [ ] [Y] [ ] [Y]
        047 - [ ] [ ] [Y] [ ] [Y] [ ] [Y] [ ]
        048 - [ ] [ ] [Y] [ ] [Y] [ ] [ ] [Y]
        049 - [ ] [ ] [Y] [ ] [ ] [Y] [ ] [Y]
        050 - [ ] [ ] [ ] [Y] [ ] [Y] [ ] [Y]

        Four houses per
        051 - [Y] [ ] [Y] [ ] [Y] [ ] [Y] [ ]
        052 - [Y] [ ] [Y] [ ] [Y] [ ] [ ] [Y]
        053 - [Y] [ ] [Y] [ ] [ ] [Y] [ ] [Y]
        054 - [Y] [ ] [ ] [Y] [ ] [Y] [ ] [Y]
        055 - [ ] [Y] [ ] [Y] [ ] [Y] [ ] [Y]
         */
    }
}