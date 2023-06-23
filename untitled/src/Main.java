import indigo._

object Main extends IndigoSandbox[Unit] {

        def setup(gameViewport: GameViewport, assetCollection: AssetCollection, dice: Dice): Startup[Unit] =
        Startup.Success(())

        def updateModel(context: FrameContext[Unit], model: Unit): GlobalEvent => Outcome[Unit] =
        _ => Outcome(model)

        def updateView(context: FrameContext[Unit], model: Unit): SceneUpdateFragment =
        SceneUpdateFragment.empty

        def initialModel(startupData: Unit): Unit =
        ()

        def assets: Set[AssetType] =
        Set.empty

        def fonts: Set[FontInfo] =
        Set.empty

        def animations: Set[Animation] =
        Set.empty

        def eventFilters: EventFilters =
        EventFilters.AllowAll

        def lightingModel: LightingModel =
        LightingModel.None

        def clearColor: ClearColor =
        ClearColor(0, 0, 0)

        def magnification: Int =
        1

        def viewport: GameViewport =
        GameViewport(320, 240)

        def frameRate: FrameRate =
        FrameRate(60)

        def run(settings: GameSettings): Unit =
        IndigoSandboxRunner.run(settings, this)

        }