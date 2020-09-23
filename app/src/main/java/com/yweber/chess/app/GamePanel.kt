package com.yweber.chess.app

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GamePanel(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    private lateinit var thread : MainThread
    init{
        holder.addCallback(this)
    }
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        holder?.let{
            thread = MainThread(holder, this)
            thread.run()
        }
    }
}