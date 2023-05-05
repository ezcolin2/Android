// 원하는 날짜에 점 찍기
class RedDotDecorator : DayViewDecorator {
    private val dates: HashSet<CalendarDay> = hashSetOf()
    private val dotSpan = DotSpan(8f, Color.RED)
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day != null && dates.contains(day)
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(dotSpan)

    }

    fun addDate(date: CalendarDay) {
        dates.add(date)
    }
}
