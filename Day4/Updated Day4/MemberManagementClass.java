class MemberManagementSystem {
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() { return members; }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void cancelMembership(Member member) {
        members.remove(member);
    }

    public void collectFine(Member member) {
        Date today = new Date();
        for (BookItem bookItem : member.getCheckedOutBooks()) {
            if (bookItem.getDueDate().before(today)) {
                long overdueDays = (today.getTime() - bookItem.getDueDate().getTime()) / (1000 * 60 * 60 * 24);
                double fine = overdueDays * 1.0;
                System.out.println("Fine for member " + member.getName() + ": Rs" + fine);
            }
        }
    }
}

