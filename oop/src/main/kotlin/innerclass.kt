fun LearnInnerClass() {
    val listView = ListView(arrayOf("Name 1", "Name 2"))

    listView.ListViewItem().displayItem(1)
    listView.displayItem(1)
}

class ListView(val items: Array<String>) {
    inner class ListViewItem() {

        fun displayItem(position: Int){
            println(items[position])
        }
    }

    fun displayItem(position: Int){
        println(items[position])
    }
}
