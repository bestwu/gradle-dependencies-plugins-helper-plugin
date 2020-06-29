/*
 * Copyright (c) 2017 Peter Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.bestwu.gdph.config;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ConfigurationView {

  private JButton resetButton;
  private JCheckBox useNexus;
  private JTextField nexusSearchUrlField;
  private JPanel dpPanel;
  private JCheckBox useMavenCentral;

  public ConfigurationView() {
    useNexus.addActionListener(
        actionEvent -> nexusSearchUrlField.setEnabled(useNexus.isSelected())
    );
  }

  public JPanel getDpPanel() {
    return dpPanel;
  }

  public String getNexusSearchUrl() {
    return nexusSearchUrlField.getText();
  }

  public void setNexusSearchUrl(String nexusSearchUrl) {
    this.nexusSearchUrlField.setText(nexusSearchUrl);
  }

  public boolean getUseNexus() {
    return useNexus.isSelected();
  }

  public void setUseNexus(boolean selected) {
    useNexus.setSelected(selected);
    nexusSearchUrlField.setEnabled(selected);
  }

  public boolean getUseMavenCentral() {
    return useMavenCentral.isSelected();
  }

  public void setUseMavenCentral(boolean useMavenCentral) {
    this.useMavenCentral.setSelected(useMavenCentral);
  }

  public JButton getResetButton() {
    return resetButton;
  }
}
