# Step Semester 3 — Daily Progress Log

## Date: 13-09-2026
**Today's Work:**
- Created feature/session_6 branch from develop.
- Solved all 5 Category A class practice problems in inheritance_polymorphism.class_problems:
  - Problem 1: EventTicket base class with constructor validation, WorkshopTicket single-inheritance specialization, and batch attendee ID registration.
  - Problem 2: PremiumWorkshopTicket multilevel inheritance and HackathonTicket hierarchical branching with polymorphic balance summation.
  - Problem 3: WorkshopTicket late-fee penalty override calling super with doubled amount and defensive copying audit trail.
  - Problem 4: Polymorphic batch ticket announcement and guarded downcasting using instanceof to access workshop track.
  - Problem 5: Static ticket ID issuance, char-by-char promo code validator without regex, overloaded payment methods, and null-safe nightly settlement.
- Completed all Category A assignment problems in inheritance_polymorphism.assigment_problems:
  - Problem 1: RaceEntry base class constructor validation, RunnerEntry single-inheritance child, and batch bib registration.
  - Problem 2: EliteRunnerEntry multilevel inheritance and RelayTeamEntry hierarchical inheritance with polymorphic total balance computation.
  - Problem 3: RunnerEntry late-withdrawal penalty override calling super with doubled rate and immutable audit history.
  - Problem 4: Race-day announcer board with StringBuilder polymorphism and guarded downcasting to RelayTeamEntry team size.
  - Problem 5: Race-wide static bib counter, char-by-char discount code format validator, overloaded pay methods, and null-tolerant settlement engine.

**Next Session Plan:**
- Explore abstraction, abstract classes vs interfaces, and multiple interface implementation in Session 7.

**Issues Faced:**
- Distinguishing between IS-A inheritance hierarchy and CAN-DO interface capabilities; ensured downcasting is safely guarded with instanceof before accessing subclass-specific members.

---

## Date: 06-09-2026
**Today's Work:**
- Created feature/session_5 branch from develop.
- Solved all 5 Category A class practice problems in encapsulation.class_problems:
  - Problems 1 & 2: AccessRuleEngine static visibility linter across contexts (same class/package, different package, cross-package subclass) and PatientRecord constructor validation.
  - Problem 3: PatientVitals encapsulation guard with silent rejection of impossible readings and defensive copying.
  - Problem 4: PatientProfile JavaBean with chained constructors, write-once ID, and write-only locker PIN.
  - Problem 5: DischargeSummary immutable legal document with medication format validation, with-mutator, and nightly batch reconciliation ledger.
- Completed all Category A assignment problems in encapsulation.assigment_problems:
  - Problems 1 & 2: AccessChecker grouped by modifier and LibraryMember constructor validation.
  - Problem 3: BookInventory circulation guard enforcing 0 <= copiesAvailable <= copiesTotal bounds.
  - Problem 4: LibraryMemberProfile JavaBean with chained constructors, write-once ID, and write-only security answer.
  - Problem 5: LoanReceipt immutable record with BK-\d{3} validation, withCorrectedBookId, and nightly circulation ledger.

**Next Session Plan:**
- Prepare for mid-semester evaluations and review OOP hierarchy designs.

**Issues Faced:**
- Understanding cross-package protected reach: access depends strictly on the declared compile-time reference type rather than runtime object identity.

---

## Date: 30-08-2026
**Today's Work:**
- Created feature/session_4 branch from develop.
- Solved all 5 Category A class practice problems in advanced_oop.class_problems:
  - Problem 1: BusTicket constructor validation against blank/invalid characters, duplicate booking prevention, and idempotent check-in.
  - Problem 2: FareSplitter constructor chaining via this(...) and remainder-fair division preserving exact total revenue.
  - Problem 3: BusRoute priority ranking engine with custom compareTo tie-breaking and manual sorting.
  - Problem 4: BoardingPenaltyCalculator with final class/methods, tiered minute rates, and minimum floor enforcement.
  - Problem 5: NightlyFleetReconciliation with static initialization block, instanceof checks, and null-safe batch processing.
- Completed all Category A assignment problems in advanced_oop.assigment_problems:
  - Problem 1: FoodOrder constructor validation against blank input, duplicate delivery alert, and batch processor.
  - Problem 2: DeliverySlot constructor chaining using this(orderId, "ASAP") and peak hour checking.
  - Problem 3: Canteen ranking engine with compareTo tiebreaking and manual insertion sort.
  - Problem 4: SurgeFeeCalculator with final methods, tiered percentage rates, and minimum floor.
  - Problem 5: DeliveryAccount batch reconciliation with static block, instanceof check for premium 50% discount, and null skipping.

**Next Session Plan:**
- Review all 4 weeks of assignments and practice for upcoming lab evaluation.

**Issues Faced:**
- Surge fee floor calculation took some time to understand that floor only applies when order is actually delayed, not when delay is 0.

---

## Date: 27-08-2026
**Today's Work:**
- Created feature/session_3 branch from develop.
- Solved all 5 Category A class practice problems in oop.class_problems:
  - F1: SrmStudent attendance tracking with instance eligibility check and static classAverage method with design justification.
  - F2: FeeAccount extension into HostelFeeAccount and ScholarshipFeeAccount without modifying base class, dispatched using instanceof.
  - F3: HostelRoom null-safe bed allotment preventing NullPointerException and verifying reference passing semantics.
  - F4: Debugged and corrected static-variable data collision in student records, properly partitioning static and instance fields.
  - F5: Fee and hostel management capstone mini-system using object composition and static student counting.
- Solved OOP homework problems F1 to F5 in oop.assigment_problems:
  - F1: Converted procedural library code to BookIssue class with instance methods and static total fine method.
  - F2: Extended Employee class with ManagerEmployee and InternEmployee without touching base class, used instanceof.
  - F3: Handled null parking slots safely in ParkingSlot allotment to avoid NullPointerException.
  - F4: Found and fixed static variables bug in LibraryMember so member details are not overwritten.
  - F5: Built HR and parking capstone mini system connecting employee objects and parking slot objects.

**Next Session Plan:**
- Practice constructor chaining (this), keyword modifiers, and batch processing in Session 4.

**Issues Faced:**
- Understood why static utility methods operating over object arrays shouldn't be instance methods and why object references don't copy objects.

---

## Date: 09-08-2026
**Today's Work:**
- Created feature/session_2 branch from develop.
- Solved all 5 Category A class practice problems in string.class_problems:
  - Problem 1: Vowel and consonant counter using charAt() loop while ignoring whitespace.
  - Problem 2: CSV student record parser with field count validation.
  - Problem 3: Case-insensitive file extension validator using lastIndexOf('.') and substring().
  - Problem 4: Phone number validator and StringBuilder masking (XXXXXX-1234).
  - Problem 5: Bank transaction reference generator and 14-character validator without regex.
- Completed all 5 assignment problems in string.assigment_problems:
  - 4-digit ATM pin validator using length().
  - Word reversal encoder reversing each word with StringBuilder.
  - Product inventory CSV line parser and field count validation.
  - ISBN code normalizer and 13-character validator without regex.
  - Stop word filter and word frequency counter using HashMap.

**Next Session Plan:**
- Start with OOP concepts, classes, objects, and constructors in Session 3.

**Issues Faced:**
- Stripping punctuation properly before counting frequencies was tricky, solved using replace().

---

## Date: 03-08-2026
**Today's Work:**
- Set up github repo Step_semester_3 and created develop and feature/session_1 branches.
- Solved all 5 Category A class practice problems in arrays.class_problems:
  - Problem 1: Rock-Paper-Scissors game simulator with 5-round scoreboard and win percentage.
  - Problem 2: Palindrome checker comparing iterative, recursive, and array-reversal approaches.
  - Problem 3: Corporate wellness BMI calculator and WHO classification report across parallel arrays.
  - Problem 4: Character frequency tracking to find the first non-repeating character.
  - Problem 5: Customer identity verification module reversing name strings while leaving original data unchanged.
- Solved all 5 homework problems in arrays.assigment_problems:
  - Seat duplicate checker using nested loops without collections.
  - Typing test accuracy percentage and first mismatch position.
  - Signal analyzer to find longest streak of same color.
  - Warehouse stock balance and highest quantity item finder.
  - Movie review word length profiler (short, medium, long).

**Next Session Plan:**
- Practice string manipulation methods and StringBuilder.

**Issues Faced:**
- Had a small confusion with 1-based indexing in inventory and typing accuracy output, but matched it with question samples.

---
