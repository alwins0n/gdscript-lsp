package io.github.alwins0n.gdscriptlsp;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.LspServerSupportProvider;
import org.jetbrains.annotations.NotNull;

public class GDScriptLspServerSupportProvider implements LspServerSupportProvider {
    @Override
    public void fileOpened(@NotNull Project project, @NotNull VirtualFile virtualFile, @NotNull LspServerSupportProvider.LspServerStarter lspServerStarter) {
        if (GDScript.FILE_EXTENSION.equals(virtualFile.getExtension())) {
            lspServerStarter.ensureServerStarted(new GDScriptLspServerDescriptor(project, GDScript.LANGUAGE_SERVER_NAME ));
        }
    }
}
