package com.github.ked4ma.atcoder

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintCaptureStream : PrintStream(ByteArrayOutputStream()) {
    fun read(): String {
        val s = out.toString()
        (out as ByteArrayOutputStream).reset()
        return s.replace("\n$".toRegex(), "")
    }
}
