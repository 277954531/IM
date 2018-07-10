
import kotlin.coroutines.experimental.buildSequence
fun main(args: Array<String>) {
//sampleStart
    val seq = buildSequence {
        for (i in 1..5) {
// 产生一个 i 的平方
            yield(i * i)
        }
// 产生一个区间
        yieldAll(26..28)
    }
// 输出该序列
    println(seq.toList())
//sampleEnd
}
// 在后台线程池中运行该代码
fun asyncOverlay() = async(CommonPool) {
    // 启动两个异步操作
    val original = asyncLoadImage("original")
    val overlay = asyncLoadImage("overlay")
// 然后应用叠加到两个结果
    applyOverlay(original.await(), overlay.await())
}
// 在 UI 上下文中启动新的协程
launch(UI) {
// 等待异步叠加完成
    val image = asyncOverlay().await()
// 然后在 UI 中显示
    showImage(image)
}