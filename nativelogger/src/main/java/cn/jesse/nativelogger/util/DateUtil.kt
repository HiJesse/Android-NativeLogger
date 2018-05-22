package cn.jesse.nativelogger.util

import java.text.SimpleDateFormat

/**
 * 日期工具类
 *
 * @author Jesse
 */
object DateUtil {
    private val TEMPLATE_DATE = "yyyy-MM-dd"

    /**
     * 以yyyy-MM-dd格式获取当前时间
     */
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat(TEMPLATE_DATE)
        return sdf.format(System.currentTimeMillis())
    }
}
